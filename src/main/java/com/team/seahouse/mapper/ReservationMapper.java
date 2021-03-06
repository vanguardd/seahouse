package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.domain.vo.LandlordReservationVo;
import com.team.seahouse.domain.vo.UserReservationVo;
import org.apache.ibatis.annotations.Param;
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
     * 根据预约信息编号查询预约详情(租客)
     * @param reservationId
     * @return
     */
    UserReservationVo findTenantByReservationId(Long reservationId);

    /**
     * 根据用户编号查询用户预约信息
     * @param userId
     * @return
     */
    List<UserReservationVo> findUserReservation(@Param("userId") Long userId);

    /**
     * 根据用户编号查询房东预约信息
     * @param userId
     * @return
     */
    List<LandlordReservationVo> findLandlordReservation(@Param("userId") Long userId);

    /**
     * 根据预约信息编号查询预约详情(房东)
     * @param reservationId
     * @return
     */
    LandlordReservationVo findLandlordByReservationId(Long reservationId);

    /**
     * 根据房东编号查询房东预约看房个数
     * @param userId
     * @return
     */
    Long selectCountByLandlord(Long userId);
}
