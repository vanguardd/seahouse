package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.domain.IdentityAuth;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.ZhiMaAuth;
import com.team.seahouse.mapper.IdentityAuthMapper;
import com.team.seahouse.mapper.UserInfoMapper;
import com.team.seahouse.mapper.UserMapper;
import com.team.seahouse.mapper.ZhiMaAuthMapper;
import com.team.seahouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @title 用户业务层实现
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ZhiMaAuthMapper zhiMaAuthMapper;

    @Autowired
    private IdentityAuthMapper identityAuthMapper;

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) throws BusinessException {
        userInfo.setUpdateTime(new Date());
        try {
            userInfoMapper.updateByPrimaryKey(userInfo);
            return userInfo;
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.REQUEST_TIMEOUT);
        }
    }

    @Override
    public void zhiMaAuth(ZhiMaAuth zhiMaAuth) {
        //设置创建时间
        zhiMaAuth.setCreateTime(new Date());
        //设置更新时间
        zhiMaAuth.setUpdateTime(new Date());
        try {
            zhiMaAuthMapper.insert(zhiMaAuth);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void identityAuth(IdentityAuth identityAuth) {
        //设置创建时间
        identityAuth.setCreateTime(new Date());
        try {
            identityAuthMapper.insert(identityAuth);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean isExistUserName(String userName) {
        User user = userMapper.findByUserName(userName);
        if(user == null) {
            return false;
        }
        return true;
    }


    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void updateUserName(String userName, Long userId) {
        //判断昵称时候存在
        Boolean isExist = isExistUserName(userName);
        if(isExist) {
            throw new BusinessException(UserReturnCode.USERNAME_EXIST);
        }
        try {
            userMapper.setUsername(userName, userId);
            userInfoMapper.setUserName(userName, userId);
        } catch (BusinessException e) {
            throw new BusinessException(e);
        }
    }
}
