package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.vo.HouseVo;

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
     * 批量添加房屋足迹
     * @param userId
     * @param houseIds
     */
    void addList(Long userId, List<Long> houseIds);

    /**
     * 查看我的足迹
     * @param userId
     * @param page
     * @return
     */
    PageResult<HouseVo> myTracks(Long userId, PageQuery page);

    /**
     * 清空足迹记录
     * @param userId
     */
    void clearTracks(Long userId);

    /**
     * 根据用户编号查询足迹个数
     * @param userId
     * @return
     */
    int selectCountByUserId(Long userId);
}
