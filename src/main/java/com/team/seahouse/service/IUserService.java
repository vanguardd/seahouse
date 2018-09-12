package com.team.seahouse.service;

import com.team.seahouse.domain.IdentityAuth;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.ZhiMaAuth;
import com.team.seahouse.domain.vo.LandlordFunction;
import com.team.seahouse.domain.vo.TenantFunction;
import com.team.seahouse.domain.vo.UserInfoVo;

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

    /**
     * 芝麻信用认证
     * @param zhiMaAuth
     */
    void zhiMaAuth(ZhiMaAuth zhiMaAuth);

    /**
     * 实名认证业务
     * @param identityAuth
     */
    void identityAuth(IdentityAuth identityAuth);

    /**
     * 校验昵称时候存在
     * @param userName
     * @return
     */
    Boolean isExistUserName(String userName);

    /**
     * 更新昵称
     * @param userName
     * @param userId
     */
    void updateUserName(String userName, Long userId);

    /**
     * 根据用户编号查询function信息
     * @param userId
     * @return
     */
    TenantFunction fundTenantByUserId(Long userId);

    /**
     * 根据用户编号查询房东信息
     * @param userId
     * @return
     */
    LandlordFunction findLandlordInfoByUserId(Long userId);
}
