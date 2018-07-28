package com.team.seahouse.service;

import com.team.seahouse.domain.House;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.QueryVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
    House findByHouseId(Long houseId);

    /**
     * 房屋搜索功能
     * 包含关键字搜索，筛选等功能
     * @param queryVo
     * @param pageable
     * @return
     */
    Page<House> search(QueryVo queryVo, Pageable pageable);

    /**
     * 根据类型查询房屋信息
     * @param type
     * @param pageable
     * @return
     */
    Page<House> findByType(Integer type, Pageable pageable);

    /**
     * 根据用户信息智能推荐房屋信息
     * @param userInfo
     * @param pageable
     * @return
     */
    Page<House> recommend(UserInfoVo userInfo, Pageable pageable);
}
