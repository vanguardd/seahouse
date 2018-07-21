package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @title 房屋模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface HouseRepository extends JpaRepository<House, Long> {

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
    List<House> findByHouseIdIn(List<Long> houseIds, Pageable pageable);
}
