package com.team.seahouse.commons.request;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * @title Jwt鉴权视图对象
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Getter@Setter
public class JwtAuthVo extends BaseDomain {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码或短信验证码
     */
    private String password;

    public JwtAuthVo() {
        super();
    }

    public JwtAuthVo(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }
}
