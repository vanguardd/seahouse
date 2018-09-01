package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Order;
import com.team.seahouse.mapper.OrderMapper;
import com.team.seahouse.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: 订单业务实现类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/31
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int selectCountByUserId(Long userId) {
        Order order = new Order();
        order.setUserId(userId);
        int count = orderMapper.selectCount(order);
        return count;
    }

    @Override
    public PageResult<Order> myOrder(Long userId, PageQuery page) {
        try {
            Order order = new Order();
            order.setUserId(userId);
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序信息
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<Order> orderList =  orderMapper.selectByExample(order);;
            PageResult<Order> result = new PageResult<Order>(orderList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }

    }
}
