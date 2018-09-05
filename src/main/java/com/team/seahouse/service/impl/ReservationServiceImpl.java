package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.domain.vo.LandlordReservationVo;
import com.team.seahouse.domain.vo.UserReservationVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.mapper.ReservationMapper;
import com.team.seahouse.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    private ReservationMapper reservationMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public void add(Reservation reservation) {
        //设置创建时间
        reservation.setCreateTime(new Date());
        //设置修改时间
        reservation.setUpdateTime(new Date());
        //执行保存操作
        try {
            reservationMapper.insert(reservation);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    @Override
    public PageResult<UserReservationVo> findUserReservationList(Long userId, PageQuery page) {
        try {
            PageHelper.startPage(page.getPage(), page.getSize());
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<UserReservationVo> reservationList = reservationMapper.findUserReservation(userId);
            PageResult<UserReservationVo> result = new PageResult<>(reservationList);
            return result;
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
    }

    @Override
    public PageResult<LandlordReservationVo> findLandlordReservationList(Long userId, PageQuery pageQuery) {
        try {
            PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());
            PageHelper.orderBy(pageQuery.getSortColumn() + " " + pageQuery.getDirection());
            List<LandlordReservationVo> reservationVoList = reservationMapper.findLandlordReservation(userId);
            PageResult<LandlordReservationVo> result = new PageResult<LandlordReservationVo>(reservationVoList);
            return result;
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Reservation reservation) {
        reservation.setUpdateTime(new Date());
        try {
            reservationMapper.insert(reservation);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public int selectCountByUserId(Long userId) {
        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        int count = reservationMapper.selectCount(reservation);
        return count;
    }
}
