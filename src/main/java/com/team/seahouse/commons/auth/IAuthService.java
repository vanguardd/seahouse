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
     * 用于登录
     * @param username
     * @param password
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
