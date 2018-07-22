package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @title 房屋模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface HouseRepository extends JpaRepository<House, Long> {

    public String baseSql = "select h.houseId, h.title, h.images, h.firstAddress, h.price, h.rentWay, h.housePattern," +
            "h.payWay, h.address, h.addressCoordinate, h.tags, h.disposition, h.area, h.exposition, h.introduce," +
            "h.houseKeeperId, h.landlordId, h.landlordName, h.updateTime from House h, Collection c where h.houseId=c.houseId";

    /**
     * 根据房屋编号查询房屋信息
     * @param houseId
     * @return
     */
    House findByHouseId(Long houseId);

    /**
     * 根据房屋编号查询出租房屋信息列表
     * @param houseIds
     * @param pageable
     * @return
     */
    Page<House> findByHouseIdIn(List<Long> houseIds, Pageable pageable);

    /**
     * 根据用户编号查询收藏的房屋列表
     * @param userId
     * @param pageable
     * @return
     */
    @Query(baseSql + " and c.userId=:userId")
    Page<House> findCollectedHouseByUserId(Long userId, Pageable pageable);
}
