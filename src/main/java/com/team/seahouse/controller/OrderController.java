package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Order;
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
     * 创建订单
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
        } catch (BusinessException e) {
            LoggerUtils.error(OrderController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK);
    }

    /**
     * 我的订单
     * @return
     */
    @GetMapping("/my")
    @ApiOperation(value = "我的订单", notes = "查询我的订单列表")
    public Response myOrder(PageQuery pageQuery) {
        Long userId = getUserId();
        try {
            PageResult<Order> pageResult = orderService.myOrder(userId, pageQuery);
            return new Response(CommonReturnCode.OK, pageResult);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
