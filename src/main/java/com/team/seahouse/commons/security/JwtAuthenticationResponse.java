package com.team.seahouse.commons.security;

import java.io.Serializable;

/**
 * @title Jwt验证响应
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
