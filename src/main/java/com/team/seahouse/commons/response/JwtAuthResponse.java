package com.team.seahouse.commons.response;

/**
 * @title JwtAuth数据封装
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/17
 */
public class JwtAuthResponse {
    /**
     * 访问Token
     */
    private String accessToken;

    /**
     *属性Token
     */
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
