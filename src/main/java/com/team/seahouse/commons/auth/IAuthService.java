package com.team.seahouse.commons.auth;

import com.team.seahouse.domain.User;
import com.team.seahouse.domain.vo.UserVo;

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
    User register(UserVo userToAdd);

    /**
     * 登录业务
     * 包含密码登录
     * @param username 手机号、邮箱等
     * @param password 密码
     * @return
     */
    String loginByPassword(String username, String password);

    /**
     * 登录业务
     * 短信验证码登录
     * @param mobilePhone 手机号
     * @param smsCode 邮箱
     * @return
     */
    String loginBySmsCode(String mobilePhone, String smsCode);


    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);
}
