package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.repository.UserInfoRepository;
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

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) throws BusinessException {
        userInfo.setUpdateDate(new Date());
        UserInfo save = null;
        try {
            save = userInfoRepository.save(userInfo);
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.REQUEST_TIMEOUT.getStatus(),
                    CommonReturnCode.REQUEST_TIMEOUT.getMessage());
        }
        return save;
    }
}
