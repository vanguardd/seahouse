package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.mapper.ReservationMapper;
import com.team.seahouse.service.IReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: 预约看房模块接口
 * @Description: 预约看房接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/20
 */
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
    public Response create(Reservation reservation) {
        try {
            reservation.setUserId(getUserId());
            reservationService.add(reservation);
            return new Response(CommonReturnCode.OK);
        } catch (Exception e) {
            LoggerUtils.error(ReservationController.class,
                    CommonReturnCode.INTERNAL_SERVER_ERROR.getMessage());
            return new Response(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 用户查看自己预约看房记录
     * @param userId
     * @return
     */
    @GetMapping("list/{userId}")
    @ApiOperation(value = "查询用户预约看房信息接口", notes = "根据用户编号查询预约看房信息")
    public Response getReservations(@PathVariable("userId") Long userId,
                                    @RequestBody PageQuery pages) {
        try {
            PageResult<Reservation> reservations = reservationService.findReservations(userId, pages);
            return new Response(CommonReturnCode.OK, reservations);
        } catch (BusinessException e) {
            LoggerUtils.error(ReservationController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 查看预约看房信息详情
     * @param reservationId
     * @return
     */
    @GetMapping("detail/{reservationId}")
    @ApiOperation(value = "查看预约详情接口", notes = "根据预约编号查看预约信息详情")
    public Response detail(@PathVariable("reservationId") Long reservationId) {
        try {
            Reservation reservation = reservationMapper.findByReservationId(reservationId);
            return new Response(CommonReturnCode.OK, reservation);
        } catch (Exception e) {
            LoggerUtils.error(ReservationController.class,
                    CommonReturnCode.INTERNAL_SERVER_ERROR.getMessage());
            return new Response(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改预约看房信息
     * @param reservation
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改预约信息", notes = "修改预约信息")
    public Response update(Reservation reservation) {
        try {
            reservationService.update(reservation);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(ReservationController.class, e.getMessage());
            return new Response(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
