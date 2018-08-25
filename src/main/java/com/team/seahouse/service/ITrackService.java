package com.team.seahouse.service;

import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Title: 足迹业务接口
 * @Description: 足迹业务接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/22
 */
public interface ITrackService {

    /**
     * 添加足迹
     * @param userId
     * @param houseId
     */
    void add(Long userId, Long houseId);

    /**
     * 查看我的足迹
     * @param userId
     * @return
     */
    Page<HouseVo> myTracks(Long userId, Pageable pageable);

    /**
     * 清空足迹记录
     * @param userId
     */
    void clearTracks(Long userId);
}
