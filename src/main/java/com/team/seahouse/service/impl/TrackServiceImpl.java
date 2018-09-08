package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.RedisKeyUtils;
import com.team.seahouse.domain.vo.HouseListVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: 足迹业务
 * @Description: 足迹业务接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/22
 */
@Service
public class TrackServiceImpl implements ITrackService {

    @Autowired
    private IRedisService<Long> redisService;

    @Value("${REDIS_TRACKS_PRE}")
    private String REDIS_TRACKS_PRE;

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public void add(Long userId, Long houseId) {
        try {
            //生成redisKey
            String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
            //每次添加前将list中该houseId去掉，再加入到头部，保证最新浏览的房屋在最前面
            redisService.remove(key, 1, houseId);
            //存入redis数据库中
            redisService.leftPush(key, houseId);

        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void addList(Long userId, List<Long> houseIds) {
        String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
        Boolean exists = redisService.exists(key);
        //如果存在该用户的足迹数据
        if(exists) {
            //添加前将list中houseIds删除，再加入到头部
            for(Long id: houseIds) {
                redisService.remove(key, 1, id);
            }
        }
        //不存在的话，直接添加到redis数据库
        redisService.leftPushAll(key, houseIds);

    }

    @Override
    public PageResult<HouseListVo> myTracks(Long userId, PageQuery page) {
        try {
            //生成redisKey
            String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
            //计算start和end
            int start = (page.getPage() - 1) * page.getSize();
            int end = page.getPage() * page.getSize() - 1;
            //查询该用户编号对应的足迹信息
            List<Long> ids = redisService.range(key, start, end);
            //查询足迹房屋列表
            List<HouseListVo> houseList = houseMapper.findByRoomIdIn(ids);
            //计算总记录数
            final Long total = redisService.size(key);
            //计算总页数
            Long totalPage = total % page.getSize() == 0 ? total / page.getSize() : total / page.getSize() + 1;
            //封装分页结果对象
            PageResult<HouseListVo> result = new PageResult<>(total, totalPage.intValue(), page.getPage(), page.getSize(), houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void clearTracks(Long userId) {
        try {
            //生成key
            String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
            //删除redis中的key
            redisService.del(key);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteTracks(Long userId, List<Long> houseIds) {
        try {
            String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
            //循环遍历房屋编号从redis中移除
            for(Long houseId : houseIds) {
                redisService.remove(key, 1, houseId);
            }
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public int selectCountByUserId(Long userId) {
        String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_TRACKS_PRE, userId);
        Long count = redisService.size(key);
        return count.intValue();
    }
}
