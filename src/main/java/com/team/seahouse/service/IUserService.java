package com.team.seahouse.service;

import com.team.seahouse.domain.UserInfo;

/**
 * @title 用户业务层接口
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/13
 */
public interface IUserService {

    /**
     * 根据Token获取用户信息
     * @param token
     * @return
     */
    UserInfo findByToken(String token);
}
