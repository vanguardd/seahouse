package com.team.seahouse.service;

import com.team.seahouse.domain.Collection;
import com.team.seahouse.domain.vo.HouseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * @param collection
     */
    void add(Collection collection);

    /**
     * 查看我的收藏的出租房屋信息列表
     * @param userId
     * @param pageable
     * @return
     */
    Page<HouseVo> getMyCollections(Long userId, Pageable pageable);
}
