package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Collections;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Title: 收藏模块
 * @Description: 收藏模块
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
public interface CollectionMapper extends BaseMapper<Collections> {

    /**
     * 根据用户编号查询收藏的出租房屋信息列表
     * @param userId
     * @return
     */
    @Select("SELECT house_id FROM tb_collection WHERE user_id=#{userId}")
    List<Long> findMyHouseIdByUserId(@Param("userId") Long userId);

    /**
     * 根据房屋编号删除收藏信息
     * @param houseId
     */
    @Delete("DELETE FROM tb_collection where house_id=#{houseId}")
    void deleteCollectionByHouseId(Long houseId);
}
