package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title: 房屋推荐
 * @Description: 根据用户芝麻信用分、用户标签、
 *              用户所在地址等信息，智能推荐房屋信息
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/24
 */
public interface RecommendRepository extends JpaRepository<House, Long> {
}
