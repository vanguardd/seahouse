package com.team.seahouse.service;

import com.team.seahouse.domain.Reservation;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Title: 预约看房业务接口
 * @Description: 预约看房业务接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/20
 */
public interface IReservationService {

    /**
     * 创建预约信息
     * @param reservation
     */
    void add(Reservation reservation);

    /**
     * 根据用户名获得预约信息集合
     * @param userId
     * @param pageable
     * @return
     */
    List<Reservation> findReservations(Long userId, Pageable pageable);

    /**
     * 修改预约看房信息
     * @param reservation
     */
    void update(Reservation reservation);
}
