package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Order;
import com.team.seahouse.domain.vo.ContractInfoVo;
import com.team.seahouse.domain.vo.OrderDetailVo;
import com.team.seahouse.domain.vo.OrderListVo;
import com.team.seahouse.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: 订单业务接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/01
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单业务", description = "包含生成订单、查询订单、我的订单")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    /**
     * 提交订单所需的数据
     * @param houseId
     * @return
     */
    @GetMapping("/contractInfo/{houseId}")
    @ApiOperation(value = "获得提交订单的数据", notes = "获得提交订单的数据信息")
    public Response contractInfo(@PathVariable("houseId") Long houseId) {
        try {
            Long userId = getUserId();
            ContractInfoVo contractInfoVo  = orderService.getContractInfo(houseId, userId);
            return new Response(CommonReturnCode.OK, contractInfoVo);
        } catch (BusinessException e) {
            LoggerUtils.error(OrderController.class, e.getMessage());
            throw new BusinessException(e.getCode(), e.getMessage());
        }

    }

    /**
     * 提交订单
     * @param order
     * @return
     */
    @PostMapping("/create")
    @ApiOperation(value = "创建订单", notes = "创建订单")
    public Response create(@RequestBody Order order) {
        try {
            Long userId = getUserId();
            order.setUserId(userId);
            orderService.create(order);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(OrderController.class, e.getMessage());
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    /**
     * 我的订单(房客)
     * @return
     */
    @GetMapping("/tenant/list")
    @ApiOperation(value = "我的订单", notes = "查询我的订单列表")
    public Response tenantOrder(PageQuery pageQuery) {
        try {
            Long userId = getUserId();
            PageResult<OrderListVo> pageResult = orderService.myOrder(userId, pageQuery);
            return new Response(CommonReturnCode.OK, pageResult);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 我的订单（房东）
     * @param pageQuery
     * @return
     */
    @GetMapping("/landlord/list")
    public Response landlordOrder(PageQuery pageQuery) {
        try {
            Long userId = getUserId();
            PageResult<OrderListVo> pageResult = orderService.getLandlordOrderList(userId, pageQuery);
            return new Response(CommonReturnCode.OK, pageResult);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @GetMapping("/detail/{orderId}")
    @ApiOperation(value = "订单详情", notes = "查询订单详情")
    public Response detail(@PathVariable("orderId") Long orderId) {
        try {
            if(orderId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            OrderDetailVo order = orderService.detail(orderId);
            return new Response(CommonReturnCode.OK, order);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新订单状态", notes = "更新订单状态")
    public Response update(Order order) {
        try {
            orderService.update(order);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new  Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 手动取消订单
     * @param orderId
     * @return
     */
    @PutMapping("/handleCancel/{orderId}")
    @ApiOperation(value = "手动取消订单", notes = "手动取消订单")
    public Response handleCancelOrder(@PathVariable("orderId") Long orderId) {
        try {
            if(orderId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            orderService.handleCancelOrder(orderId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
