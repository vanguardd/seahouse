package com.team.seahouse.commons.auth;


import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.JwtAuthResponse;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.security.SmsCodeAuthenticationToken;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.commons.request.UserVo;
import com.team.seahouse.mapper.UserInfoMapper;
import com.team.seahouse.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @title 用户认证业务
 * @describe 包含注册、密码登录和验证码登录
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserMapper userMapper;
    private UserInfoMapper userInfoMapper;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserMapper userMapper,
            UserInfoMapper userInfoMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
        this.userInfoMapper = userInfoMapper;
    }

    @Transactional(rollbackFor = ValidateException.class)
    @Override
    public JwtAuthResponse register(UserVo userToAdd) throws ValidateException {
        final String mobilePhone = userToAdd.getMobilePhone();
        if(userMapper.findByMobilePhone(mobilePhone) != null) {
            throw new ValidateException(UserReturnCode.ACCOUNT_ERROR.getStatus(), UserReturnCode.ACCOUNT_ERROR.getMessage());
        }
        //创建用户对象，并设置用户登录信息
        User user = new User();
        user.setMobilePhone(mobilePhone);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        //加密密码
        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(new Date());
        user.setUserName(userToAdd.getUserName());
        //设置默认的用户状态(正常)
        user.setState(StatusEnum.NORMAL.getStatus());

        //保存用户登录信息
        try {
            userMapper.insert(user);
            //创建用户详细信息，并设置详细信息
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setUserName(user.getUserName());
            userInfo.setMobilePhone(user.getMobilePhone());
            userInfo.setEmail(user.getEmail());
            userInfo.setAvatar(userToAdd.getAvatar());
            userInfo.setSex(userToAdd.getSex());
            userInfo.setBornDate(userToAdd.getBornDate());
            userInfo.setCompanyAddress(userToAdd.getCompanyAddress());
            userInfo.setCreateTime(new Date());
            userInfo.setUpdateTime(new Date());

            //保存用户详细信息
            userInfoMapper.insert(userInfo);

            log.info("register success : " + userToAdd.getMobilePhone());

            log.info("auto login...");
            //注册成功后，自动登录并返回token
            return loginByPassword(userToAdd.getMobilePhone(), userToAdd.getPassword());
        } catch (ValidateException e) {
            throw new ValidateException(e.getCode(), e.getMessage());
        }
    }

    @Override
    public JwtAuthResponse loginByPassword(String userName, String password) throws ValidateException {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            return authenticateToken(upToken, userName);
        } catch (ValidateException e) {
            throw new ValidateException(e.getCode(), e.getMessage());
        }

    }

    @Override
    public JwtAuthResponse loginBySmsCode(String mobilePhone, String smsCode) {
        SmsCodeAuthenticationToken upToken = new SmsCodeAuthenticationToken(mobilePhone, smsCode);
        try {
            return authenticateToken(upToken, mobilePhone);
        } catch (ValidateException e) {
            throw new ValidateException(e.getCode(), e.getMessage());
        }
    }

    @Override
    public JwtAuthResponse refresh(String refreshToken) {
        String userName = jwtTokenUtil.getUsernameFromToken(refreshToken);
        log.info("authentication : " + userName);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(userName);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setRefreshToken(refreshToken);
        String accessToken = "";
        if (jwtTokenUtil.canTokenBeRefreshed(refreshToken, user.getLastPasswordResetDate())) {
            accessToken = jwtTokenUtil.refreshToken(refreshToken);
            response.setAccessToken(accessToken);
        } else {
            throw new ValidateException(CommonReturnCode.UNAUTHORIZED);
        }
        return response;
    }

    /**
     * 验证认证逻辑并生成Token
     * @param upToken
     * @param userName
     * @return
     */
    public JwtAuthResponse authenticateToken(AbstractAuthenticationToken upToken, String userName) {
        //验证认证逻辑
        final Authentication authentication = authenticationManager.authenticate(upToken);
        //将Authentication存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //根据用户名查询用户信息
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        JwtAuthResponse response = new JwtAuthResponse();
        //生成AccessToken
        final String accessToken = jwtTokenUtil.generateAccessToken(userDetails);
        log.info("generateAccessToken success");

        //生成RefreshToken
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);
        log.info("generateAccessToken success");

        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }
}
