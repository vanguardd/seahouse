package com.team.seahouse.commons.auth;


import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.security.SmsCodeAuthenticationToken;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.vo.JwtUser;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.UserVo;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.UserRepository;
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

import java.util.Date;

/**
 * @title
 * @describe
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

    @Override
    public User register(UserVo userToAdd) throws ValidateException {
        final String mobilePhone = userToAdd.getMobilePhone();
        if(userRepository.findByMobilePhone(mobilePhone) != null) {
            throw new ValidateException(UserReturnCode.ACCOUNT_ERROR.getStatus(), UserReturnCode.ACCOUNT_ERROR.getMessage());
        }
        //创建用户对象，并设置用户登录信息
        User user = new User();
        user.setMobilePhone(mobilePhone);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(new Date());
        user.setUserName(userToAdd.getUserName());

        //保存用户登录信息
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

        return registerUser;
    }

    @Override
    public String loginByPassword(String userName, String password) throws ValidateException {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            return authenticateToken(upToken, userName);
        } catch (ValidateException e) {
            throw new ValidateException(e.getCode(), e.getMessage());
        }

    }

    @Override
    public String loginBySmsCode(String mobilePhone, String smsCode) {
        SmsCodeAuthenticationToken upToken = new SmsCodeAuthenticationToken(mobilePhone, smsCode);
        try {
            return authenticateToken(upToken, mobilePhone);
        } catch (ValidateException e) {
            throw new ValidateException(e.getCode(), e.getMessage());
        }
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String userName = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(userName);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    /**
     * 验证认证逻辑并生成Token
     * @param upToken
     * @param userName
     * @return
     */
    public String authenticateToken(AbstractAuthenticationToken upToken, String userName) {
        //验证认证逻辑
        final Authentication authentication = authenticationManager.authenticate(upToken);
        //将Authentication存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //根据用户名查询用户信息
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        //生成Token
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }
}
