package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.domain.House;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @title 房屋模块业务实现
 * @describe 房屋模块业务实现
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private IRedisService redisService;

    @Override
    public void publish(House house) {
        //设置审核状态默认为未审核
        house.setAuditState(StatusEnum.UN_AUDIT.getStatus());
        //设置创建时间
        house.setCreateTime(new Date());
        //设置更新时间
        house.setUpdateTime(new Date());
        try {
            houseRepository.save(house);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(House house) {
        //设置更新时间
        house.setUpdateTime(new Date());
        try {
            houseRepository.save(house);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public House findByHouseId(Long houseId) {
        try {
            House house = houseRepository.findByHouseId(houseId);
            return house;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
    }
}
