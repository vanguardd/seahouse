package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Collections;
import com.team.seahouse.domain.vo.HouseVo;

/**
 * @Title: 收藏业务接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
public interface ICollectionService {
    /**
     * 添加收藏信息
     * @param collections
     */
    void add(Collections collections);

    /**
     * 查看我的收藏的出租房屋信息列表
     * @param userId
     * @param page
     * @return
     */
    PageResult<HouseVo> getMyCollections(Long userId, PageQuery page);

    /**
     * 根据用户编号查询收藏个数
     * @param userId
     * @return
     */
    int selectCountByUserId(Long userId);
}
