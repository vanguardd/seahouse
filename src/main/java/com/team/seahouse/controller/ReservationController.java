package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Reservation;
import com.team.seahouse.repository.ReservationRepository;
import com.team.seahouse.service.IReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ReservationRepository reservationRepository;

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
     * @param page
     * @param size
     * @return
     */
    @GetMapping("list/{userId}")
    @ApiOperation(value = "查询用户预约看房信息接口", notes = "根据用户编号查询预约看房信息")
    public Response getReservations(@PathVariable("userId") Long userId,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "15") Integer size) {
        //以创建时间降序排序
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        //封装分页对象
        Pageable pageable = new PageRequest(page, size, sort);
        try {
            List<Reservation> reservations = reservationService.findReservations(userId, pageable);
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
            Reservation reservation = reservationRepository.findByReservationId(reservationId);
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
