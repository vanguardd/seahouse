package com.team.seahouse.repository;

import com.team.seahouse.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Title: 收藏模块
 * @Description: 收藏模块
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    /**
     * 根据用户编号查询收藏的出租房屋信息列表
     * @param userId
     * @return
     */
    @Query("select houseId from Collection where userId=:userId")
    List<Long> findMyHouseIdByUserId(@Param("userId") Long userId);

    /**
     * 根据房屋编号删除收藏信息
     * @param houseId
     */
    void deleteCollectionByHouseId(Long houseId);
}
