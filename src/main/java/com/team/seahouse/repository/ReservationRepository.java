package com.team.seahouse.repository;

import com.team.seahouse.domain.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @title 预约信息模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/20
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * 根据预约信息编号查询预约详情
     * @param reservationId
     * @return
     */
    Reservation findByReservationId(Long reservationId);

    /**
     * 根据用户编号分页查询预约信息集合
     * @param userId
     * @param pageable
     * @return
     */
    Page<Reservation> findAllByUserId(Long userId, Pageable pageable);
}
