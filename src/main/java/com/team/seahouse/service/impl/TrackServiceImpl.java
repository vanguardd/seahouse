package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private IRedisService<Set<Long>> redisService;

    @Value("${REDIS_TRACKS_PRE}")
    private String REDIS_TRACKS_PRE;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public void add(Long userId, Long houseId) {
        try {
            //创建Set集合存放房屋Id
            Set<Long> ids = new  HashSet<Long>();
            ids.add(userId);
            //存入redis数据库中
            redisService.set(REDIS_TRACKS_PRE + ":" + userId, ids);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PageResult<HouseVo> myTracks(Long userId, PageQuery page) {
        try {
            //查询该用户编号对应的足迹信息
            Set<Long> ids = redisService.get(REDIS_TRACKS_PRE + ":" + userId);
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseVo> houseList = houseMapper.findByHouseIdIn(ids);
            PageResult<HouseVo> result = new PageResult<>(houseList);
            return result;
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
