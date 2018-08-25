package com.team.seahouse.commons.auth;


import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.JwtAuthResponse;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.security.SmsCodeAuthenticationToken;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.vo.JwtUser;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.UserVo;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.UserRepository;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Service
public class AuthServiceImpl implements IAuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;
    private UserInfoRepository userInfoRepository;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserRepository userRepository,
            UserInfoRepository userInfoRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JwtAuthResponse register(UserVo userToAdd) throws ValidateException {
        final String mobilePhone = userToAdd.getMobilePhone();
        if(userRepository.findByMobilePhone(mobilePhone) != null) {
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
            User registerUser = userRepository.save(user);
            //创建用户详细信息，并设置详细信息
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(registerUser.getUserId());
            userInfo.setUserName(registerUser.getUserName());
            userInfo.setMobilePhone(registerUser.getMobilePhone());
            userInfo.setEmail(registerUser.getEmail());
            userInfo.setAvatar(userToAdd.getAvatar());
            userInfo.setSex(userToAdd.getSex());
            userInfo.setBornDate(userToAdd.getBornDate());
            userInfo.setCompanyAddress(userToAdd.getCompanyAddress());
            userInfo.setCreateDate(new Date());
            userInfo.setUpdateDate(new Date());

            //保存用户详细信息
            userInfoRepository.save(userInfo);

            LoggerUtils.info(AuthServiceImpl.class, "register success : " + userToAdd.getMobilePhone());

            LoggerUtils.info(AuthServiceImpl.class, "auto login...");
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
        final String token = refreshToken.substring(tokenHead.length());
        String userName = jwtTokenUtil.getUsernameFromToken(token);
        LoggerUtils.info(AuthServiceImpl.class, " authentication : " + userName);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(userName);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setRefreshToken(refreshToken);
        String accessToken = "";
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            accessToken = jwtTokenUtil.refreshToken(token);
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
        LoggerUtils.info(AuthServiceImpl.class, "generateAccessToken success");

        //生成RefreshToken
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);
        LoggerUtils.info(AuthServiceImpl.class, "generateAccessToken success");

        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }
}
