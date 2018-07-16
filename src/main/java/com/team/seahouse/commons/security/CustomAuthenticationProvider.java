package com.team.seahouse.commons.security;

import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * 自定义身份认证验证组件
 *
 * @author zhaoxinguo on 2017/9/12.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ISmsSenderService smsSenderService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService,
                                        BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws ValidateException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        try {
            // 认证逻辑
            UserDetails userDetails = userDetailsService.loadUserByUsername(name);
            //加密后的密码和用户输入的密码进行比较
            if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password);
                return auth;
            } else {
                throw new ValidateException(UserReturnCode.WRONG_PASSWORD);
            }
        } catch (UsernameNotFoundException e) {
            throw new ValidateException(UserReturnCode.USER_NOT_EXIST);
        }

    }

    /**
     * 是否可以提供输入类型的认证服务
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
