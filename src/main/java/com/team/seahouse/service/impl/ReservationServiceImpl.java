package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.repository.ReservationRepository;
import com.team.seahouse.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title: 预约业务接口实现类
 * @Description: 预约看房信息
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/20
 */
@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void add(Reservation reservation) {
        //设置创建时间
        reservation.setCreateTime(new Date());
        //设置修改时间
        reservation.setUpdateTime(new Date());
        //执行保存操作
        reservationRepository.save(reservation);
    }

    @Override
    public Page<Reservation> findReservations(Long userId, Pageable pageable) {
        try {
            Page<Reservation> reservationPage = reservationRepository.findAllByUserId(userId, pageable);
            return reservationPage;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Reservation reservation) {
        reservation.setUpdateTime(new Date());
        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
