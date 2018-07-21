package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
