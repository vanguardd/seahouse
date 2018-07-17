package com.team.seahouse.commons.security;

import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @title 短信验证码验证
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    /**
     * 验证码验证服务
     */
    private ISmsSenderService smsSenderService;

    /**
     * 检查用户名
     */
    private UserDetailsService userDetailsService;

    /**
     * redis服务
     */
    private IRedisService redisService;

    public SmsCodeAuthenticationProvider(UserDetailsService userDetailsService,
                                         ISmsSenderService smsSenderService,
                                         IRedisService redisService) {
        this.smsSenderService = smsSenderService;
        this.userDetailsService = userDetailsService;
        this.redisService = redisService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String validateCode = authentication.getCredentials().toString();
        try {
            //验证手机号是否已注册
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //验证短信验证码
            boolean isCorrectCode = smsSenderService.checkIsCorrectCode(username, validateCode);
            if(isCorrectCode) {
                Authentication auth = new SmsCodeAuthenticationToken(username, validateCode);
                //验证成功后，手动删除redis中的验证码
                redisService.remove(username);
                return auth;
            } else {
                throw new ValidateException(UserReturnCode.REGISTER_CODE_ERROR);
            }
        } catch (UsernameNotFoundException e) {
            throw new ValidateException(UserReturnCode.MOBILE_PHONE_NOT_EXIST);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(SmsCodeAuthenticationToken.class);
    }
}
