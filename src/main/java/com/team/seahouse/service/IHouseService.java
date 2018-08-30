package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.commons.request.SearchQuery;
import com.team.seahouse.domain.vo.UserInfoVo;

/**
 * @title 房屋业务接口
 * @describe 房屋业务接口
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface IHouseService {

    /**
     * 发布出租房屋信息
     * @param house
     */
    void publish(House house);

    /**
     * 更新出租房屋信息
     * @param house
     */
    void update(House house);

    /**
     * 根据房屋编号查询出租房屋信息详情
     * @param houseId
     * @return
     */
    HouseDetailVo findByHouseId(Long houseId, Long userId);

    /**
     * 房屋搜索功能
     * 包含关键字搜索，筛选等功能
     * @param searchQuery
     * @return
     */
    PageResult<HouseVo> search(SearchQuery searchQuery);

    /**
     * 根据类型查询房屋信息
     * @param type
     * @param pageInfo
     * @return
     */
    PageResult<HouseVo> findByType(Integer type, PageQuery pageInfo);

    /**
     * 根据用户信息智能推荐房屋信息
     * @param userInfo
     * @param pageInfo
     * @return
     */
    PageResult<HouseVo> recommend(UserInfoVo userInfo, PageQuery pageInfo);
}
