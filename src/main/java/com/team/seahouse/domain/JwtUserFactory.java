package com.team.seahouse.domain;

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
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getMobilePhone(),
                user.getEmail(),
                user.getLastPasswordResetDate()
        );
    }
}
