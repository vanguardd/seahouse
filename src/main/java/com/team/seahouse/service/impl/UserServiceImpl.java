package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.AuditStatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.domain.*;
import com.team.seahouse.domain.vo.LandlordFunction;
import com.team.seahouse.domain.vo.TenantFunction;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.mapper.*;
import com.team.seahouse.service.*;
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

    @Autowired
    private ICollectionService collectionService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ITrackService trackService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private IRoomService roomService;

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
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void identityAuth(IdentityAuth identityAuth) {
        //设置创建时间
        identityAuth.setCreateTime(new Date());
        identityAuth.setState(AuditStatusEnum.UN_AUDIT.getStatus());
        try {
            //保存实名认证信息
            identityAuthMapper.insert(identityAuth);
            //更新用户信息的真实姓名
            userInfoMapper.setRealName(identityAuth.getRealName(), identityAuth.getUserId());
        } catch (BusinessException e) {
            throw new BusinessException(e);
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

    @Override
    public TenantFunction fundTenantByUserId(Long userId) {
        TenantFunction tenantFunction = new TenantFunction();
        //获得收藏个数
        int collectionCount = collectionService.selectCountByUserId(userId);
        tenantFunction.setCollectionCount(collectionCount);
        //获得预约个数
        int reservationCount = reservationService.selectCountByUserId(userId);
        tenantFunction.setReservationCount(reservationCount);
        //获得订单个数
        int orderCount = orderService.selectCountByUserId(userId);
        tenantFunction.setOrderCount(orderCount);
        //获得足迹个数
        int trackCount = trackService.selectCountByUserId(userId);
        tenantFunction.setTrackCount(trackCount);
        return tenantFunction;
    }

    @Override
    public LandlordFunction findLandlordInfoByUserId(Long userId) {
        LandlordFunction landlordFunction = new LandlordFunction();
        int reservationCount = reservationService.selectCountByLandlordId(userId);
        landlordFunction.setReservationCount(reservationCount);
        int houseCount = houseService.selectCountByLandlordId(userId);
        landlordFunction.setHouseCount(houseCount);
        int roomCount = roomService.selectCountByLandlordId(userId);
        landlordFunction.setRoomCount(roomCount);
        int orderCount = orderService.selectCountByLandlordId(userId);
        landlordFunction.setOrderCount(orderCount);
        int tenantCount = orderService.selectTenantCountByLandlord(userId);
        landlordFunction.setTenantCount(tenantCount);
        return landlordFunction;
    }
}
