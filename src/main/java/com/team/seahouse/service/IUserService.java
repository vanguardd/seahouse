package com.team.seahouse.service;

import com.team.seahouse.domain.User;
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
     * 修改用户信息
     * @param userInfo
     * @return
     */
    UserInfo updateUserInfo(UserInfo userInfo);

}
