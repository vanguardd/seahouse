package com.team.seahouse.commons.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @title Jwt验证请求类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
@Getter@Setter
public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String loginName;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String loginName, String password) {
        this.setLoginName(loginName);
        this.setPassword(password);
    }

}
