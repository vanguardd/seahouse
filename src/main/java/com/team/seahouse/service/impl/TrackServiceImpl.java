package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.domain.House;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: 足迹业务接口
 * @Description: 足迹业务接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/22
 */
@Service
public class TrackServiceImpl implements ITrackService {

    @Autowired
    private IRedisService<House> redisService;

    @Value("${REDIS_TRACKS_PRE}")
    private String REDIS_TRACKS_PRE;

    @Autowired
    private IHouseService houseService;

    @Override
    public void add(Long userId, Long houseId) {
        try {
            //根据房屋编号查询房屋详细信息
            House house = houseService.findByHouseId(houseId);
            //查询足迹中是否有该房屋信息
            boolean isExist = redisService.hexists(REDIS_TRACKS_PRE + ":" + userId, houseId.toString());
            if(!isExist) {
                //存入redis数据库中
                redisService.hput(REDIS_TRACKS_PRE + ":" + userId, houseId.toString(), house);
            }
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<House> myTracks(Long userId) {
        try {
            //查询该用户编号对应的足迹信息
            List<House> houseList = redisService.hvals(REDIS_TRACKS_PRE + ":" + userId);
            return houseList;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void clearTracks(Long userId) {
        try {
            redisService.del(REDIS_TRACKS_PRE + ":" + userId);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
