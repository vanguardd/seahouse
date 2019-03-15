package com.team.seahouse.commons.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Title: 手机号和验证码验证Token
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2019/3/15
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 2383092775910246006L;

    /**
     * 手机号
     */
    private final Object principal;

    /**
     * 验证码
     */
    private Object credentials;

    /**
     * SmsCodeAuthenticationFilter中构建的未认证的Authentication
     * @param mobile
     */
    public SmsCodeAuthenticationToken(String mobile, String smsCode) {
        super(null);
        this.principal = mobile;
        this.credentials = smsCode;
        setAuthenticated(false);
    }

    /**
     * SmsCodeAuthenticationProvider中构建已认证的Authentication
     * @param principal
     * @param authorities
     */
    public SmsCodeAuthenticationToken(Object principal,
                                      Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    /**
     * @param isAuthenticated
     * @throws IllegalArgumentException
     */
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
