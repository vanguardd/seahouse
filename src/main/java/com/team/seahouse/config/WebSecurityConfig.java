package com.team.seahouse.config;

import com.team.seahouse.commons.filter.*;
import com.team.seahouse.commons.security.CustomAuthenticationProvider;
import com.team.seahouse.commons.security.SmsCodeAuthenticationProvider;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @author zhaoxinguo on 2017/9/13.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 需要放行的URL
     */
    private static final String[] AUTH_WHITELIST = {
            // -- register url
            "/users/register",
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/auth/**",
            "/sms/**"
    };

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ISmsSenderService smsSenderService;

    @Autowired
    private IRedisService redisService;

    /**
     * 装载BCrypt密码编码器
     * @return PasswordEncoder 密码解码器
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 设置 HTTP 验证规则
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated()  // 所有请求需要身份认证
            .and()
            .logout() // 默认注销行为为logout，可以通过下面的方式来修改
            .logoutUrl("/pass/logout")
            .permitAll();
        // 添加JWT filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }

    /**
     * 登录的时候进入此方法
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(new SmsCodeAuthenticationProvider(userDetailsService, smsSenderService,
                redisService)).
                authenticationProvider(new CustomAuthenticationProvider(userDetailsService, passwordEncoder()));
    }
}
