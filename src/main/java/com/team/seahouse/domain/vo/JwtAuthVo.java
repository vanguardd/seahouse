package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/17
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
