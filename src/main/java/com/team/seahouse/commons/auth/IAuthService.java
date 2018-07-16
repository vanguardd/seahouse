package com.team.seahouse.commons.auth;

import com.team.seahouse.domain.User;

/**
 * @title Auth Service接口
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
public interface IAuthService {
    /**
     * 用户注册
     * @param userToAdd
     * @return
     */
    User register(User userToAdd);

    /**
     * 登录业务
     * 包含密码登录、短信验证码登录和第三方登录
     * @param username 手机号、邮箱等
     * @param password 密码或者验证码
     * @return
     */
    String login(String username, String password);


    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);
}
