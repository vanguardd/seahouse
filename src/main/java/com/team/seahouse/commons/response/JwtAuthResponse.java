package com.team.seahouse.commons.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @title JwtAuth数据封装
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/17
 */
@Getter@Setter
public class JwtAuthResponse {
    /**
     * 访问Token
     */
    private String accessToken;

    /**
     * 刷新Token
     */
    private String refreshToken;

}
