package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Reservation;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @title 预约信息模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/20
 */
public interface ReservationMapper extends BaseMapper<Reservation> {

    /**
     * 根据预约信息编号查询预约详情
     * @param reservationId
     * @return
     */
    @Select("SELECT * FROM tb_reservation WHERE id=#{reservationId}")
    Reservation findByReservationId(Long reservationId);

    /**
     * 根据用户编号分页查询预约信息集合
     * @param userId
     * @return
     */
    List<Reservation> findAllByUserId(Long userId);
}
