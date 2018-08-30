package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Reservation;
import org.springframework.data.domain.Page;

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
     * @param pageInfo
     * @return
     */
    PageResult<Reservation> findReservations(Long userId, PageQuery pageInfo);

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
