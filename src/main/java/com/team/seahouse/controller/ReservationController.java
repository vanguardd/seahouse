package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.domain.vo.LandlordReservationVo;
import com.team.seahouse.domain.vo.UserReservationVo;
import com.team.seahouse.mapper.ReservationMapper;
import com.team.seahouse.service.IReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * @Title: 预约看房模块接口
 * @Description: 预约看房接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/20
 */
@Slf4j
@RestController
@RequestMapping("/reservation")
@Api(value = "预约看房模块接口", description = "预约看房接口")
public class ReservationController extends BaseController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;

    /**
     * 新增预约看房信息
     * @param reservation
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "创建预约看房信息", notes = "创建预约看房信息")
    public Response create(@RequestBody Reservation reservation) {
        try {
            Long userId = getUserId();
            reservation.setUserId(userId);
            reservationService.add(reservation);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 用户查看自己预约看房记录
     * @return
     */
    @GetMapping("/user/list")
    @ApiOperation(value = "用户查看预约看房信息接口", notes = "用户查看自己预约看房的信息接口")
    public Response userReservations(PageQuery pages) {
        try {
            Long userId = getUserId();
            PageResult<UserReservationVo> reservations = reservationService.findUserReservationList(userId, pages);
            return new Response(CommonReturnCode.OK, reservations);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @GetMapping("/landlord/list")
    @ApiOperation(value = "房东查看预约看房信息", notes = "房东查询出租房屋预约看房信息接口")
    public Response landlordReservation(PageQuery pageQuery) {
        try {
            Long userId = getUserId();
            PageResult<LandlordReservationVo> reservationList = reservationService.findLandlordReservationList(userId, pageQuery);
            return new Response(CommonReturnCode.OK, reservationList);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查看预约看房信息详情（租客）
     * @param reservationId
     * @return
     */
    @GetMapping("/detail/tenant/{reservationId}")
    @ApiOperation(value = "查看预约详情接口", notes = "根据预约编号查看预约信息详情（租客）")
    public Response detail(@PathVariable("reservationId") Long reservationId) {
        try {
            if(reservationId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            UserReservationVo reservation = reservationMapper.findTenantByReservationId(reservationId);
            return new Response(CommonReturnCode.OK, reservation);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查看预约看房信息详情（房东）
     * @param reservationId
     * @return
     */
    @GetMapping("/detail/landlord/{reservationId}")
    @ApiOperation(value = "查看预约详情接口", notes = "根据编号查看预约信息详情（房东）")
    public Response landlordDetail(@PathVariable("reservationId") Long reservationId) {
        try {
            if(reservationId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            LandlordReservationVo reservation = reservationMapper.findLandlordByReservationId(reservationId);
            return new Response(CommonReturnCode.OK, reservation);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 修改预约看房信息
     * @param reservation
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改预约信息", notes = "修改预约信息状态等")
    public Response update(@RequestBody Reservation reservation) {
        try {
            reservationService.update(reservation);
        } catch (BusinessException e) {
            log.error(e.getMessage());
        }
        return new Response(CommonReturnCode.OK);

    }
}
