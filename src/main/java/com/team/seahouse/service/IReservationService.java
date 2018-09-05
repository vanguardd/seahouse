package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.domain.vo.LandlordReservationVo;
import com.team.seahouse.domain.vo.UserReservationVo;

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
     * @param userId 房客用户编号
     * @param pageInfo 分页信息
     * @return
     */
    PageResult<UserReservationVo> findUserReservationList(Long userId, PageQuery pageInfo);

    /**
     * 根据房东用户编号查询预约看房信息
     * @param userId 房东用户编号
     * @param pageQuery 分页信息
     * @return
     */
    PageResult<LandlordReservationVo> findLandlordReservationList(Long userId, PageQuery pageQuery);

    /**
     * 修改预约看房信息
     * @param reservation
     */
    void update(Reservation reservation);

    /**
     * 根据用户编号查询预约个数
     * @param userId
     * @return
     */
    int selectCountByUserId(Long userId);
}
