package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.team.seahouse.commons.enums.ContractStatusEnum;
import com.team.seahouse.commons.enums.OrderStatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.OrderUtils;
import com.team.seahouse.domain.Contract;
import com.team.seahouse.domain.Order;
import com.team.seahouse.domain.vo.ContractInfoVo;
import com.team.seahouse.domain.vo.OrderListVo;
import com.team.seahouse.mapper.OrderMapper;
import com.team.seahouse.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
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
    public Order create(Order order) {
        //生成订单号
        String orderNumber = OrderUtils.getOrderNumber(order.getUserId());
        order.setOrderNumber(orderNumber);
        order.setState(OrderStatusEnum.SUBMIT_ORDERS.getStatus());
        order.setRenterSignState(ContractStatusEnum.NO_SIGN.getStatus());
        order.setLandlordSignState(ContractStatusEnum.NO_SIGN.getStatus());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        try {
            orderMapper.insert(order);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return order;
    }

    @Override
    public PageResult<OrderListVo> myOrder(Long userId, PageQuery page) {
        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序信息
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<OrderListVo> orderList =  orderMapper.findByUserId(userId);
            PageResult<OrderListVo> result = new PageResult<>(orderList);
            return result;
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public int selectCountByLandlordId(Long userId) {
        Order order = new Order();
        order.setLandlordId(userId);
        int count = orderMapper.selectCount(order);
        return count;
    }

    @Override
    public int selectTenantCountByLandlord(Long userId) {
        Order order = new Order();
        order.setLandlordId(userId);
        order.setState(OrderStatusEnum.PAY_TO_COMPLETE.getStatus());
        int count = orderMapper.selectCount(order);
        return count;
    }

    @Override
    public ContractInfoVo getContractInfo(Long houseId, Long userId) {
        ContractInfoVo contractInfoVo = null;
        try {
            contractInfoVo = orderMapper.getContractInfo(houseId, userId);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return contractInfoVo;
    }

}
