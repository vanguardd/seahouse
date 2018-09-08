package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseListVo;
import com.team.seahouse.commons.request.SearchQuery;
import com.team.seahouse.domain.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @title 房屋模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface HouseMapper extends BaseMapper<House> {

    /**
     * 根据房屋编号查询房屋信息（已经登录）
     * @param roomId 房屋编号
     * @param userId 用户编号
     * @return
     */
    HouseDetailVo findByRoomIdLogin(@Param("roomId") Long roomId, @Param("userId") Long userId);

    /**
     * 根据房屋编号查询房屋信息（没有登录）
     * @param roomId
     * @return
     */
    HouseDetailVo findByRoomId(@Param("roomId") Long roomId);

    /**
     * 根据房屋编号查询出租房屋信息列表
     * @param roomIds
     * @return
     */
    List<HouseListVo> findByRoomIdIn(@Param("roomIds") List<Long> roomIds);

    /**
     * 根据用户编号查询收藏的房屋列表
     * @param userId
     * @return
     */
    List<HouseListVo> findCollectedHouseByUserId(Long userId);

    /**
     * 根据类型查询房屋信息
     * @param type
     * @return
     */
    List<HouseListVo> findHousesByType(Integer type);

    /**
     * 房屋搜索筛选
     * @param searchQuery
     * @return
     */
    List<HouseListVo> search(SearchQuery searchQuery);

    /**
     * 根据用户信息推荐房屋信息
     * @param userInfo 用户信息
     * @return
     */
    List<HouseListVo> findByUserInfo(UserInfoVo userInfo);

}
