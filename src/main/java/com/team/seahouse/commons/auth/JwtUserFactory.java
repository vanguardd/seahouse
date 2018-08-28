package com.team.seahouse.commons.auth;

import com.team.seahouse.domain.User;

/**
 * @title JwtUser 工厂类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getMobilePhone(),
                user.getPassword(),
                user.getLastPasswordResetDate(),
                user.getState()
        );
    }
}
