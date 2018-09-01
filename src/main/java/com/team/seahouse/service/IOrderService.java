package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Order;

/**
 * @Title: 订单业务接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/31
 */
public interface IOrderService {

    /**
     * 根据用户编号查询订单个数
     * @param userId
     * @return
     */
    int selectCountByUserId(Long userId);

    /**
     * 查询我的订单
     * @param userId 用户编号
     * @param page 分页信息
     * @return
     */
    PageResult<Order> myOrder(Long userId, PageQuery page);
}
