package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.IdentityAuth;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.ZhiMaAuth;
import com.team.seahouse.repository.IdentityAuthRepository;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.ZhiMaAuthRepository;
import com.team.seahouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ZhiMaAuthRepository zhiMaAuthRepository;

    @Autowired
    private IdentityAuthRepository identityAuthRepository;

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) throws BusinessException {
        userInfo.setUpdateDate(new Date());
        UserInfo save = null;
        try {
            save = userInfoRepository.save(userInfo);
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.REQUEST_TIMEOUT);
        }
        return save;
    }

    @Override
    public void zhiMaAuth(ZhiMaAuth zhiMaAuth) {
        //设置创建时间
        zhiMaAuth.setCreateTime(new Date());
        //设置更新时间
        zhiMaAuth.setUpdateTime(new Date());
        try {
            zhiMaAuthRepository.save(zhiMaAuth);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void identityAuth(IdentityAuth identityAuth) {
        //设置创建时间
        identityAuth.setCreateTime(new Date());
        try {
            identityAuthRepository.save(identityAuth);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
