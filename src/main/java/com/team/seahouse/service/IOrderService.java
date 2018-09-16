package com.team.seahouse.service;

import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Order;
import com.team.seahouse.domain.vo.ContractInfoVo;
import com.team.seahouse.domain.vo.OrderDetailVo;
import com.team.seahouse.domain.vo.OrderListVo;

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
     * 生成订单
     * @param order
     * @return
     */
    Order create(Order order);

    /**
     * 查询我的订单
     * @param userId 用户编号
     * @param page 分页信息
     * @return
     */
    PageResult<OrderListVo> myOrder(Long userId, PageQuery page);

    /**
     * 根据房东编号查询订单个数
     * @param userId
     * @return
     */
    int selectCountByLandlordId(Long userId);

    /**
     * 根据房东编号查询房客个数
     * @param userId
     * @return
     */
    int selectTenantCountByLandlord(Long userId);

    /**
     * 获得创建订单所需的信息
     * @param houseId
     * @param userId
     * @return
     */
    ContractInfoVo getContractInfo(Long houseId, Long userId);

    /**
     * 查询房东的订单列表
     * @param userId
     * @param pageQuery
     * @return
     */
    PageResult<OrderListVo> getLandlordOrderList(Long userId, PageQuery pageQuery);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderDetailVo detail(Long orderId);

    /**
     * 更新订单状态
     * @param order
     */
    void update(Order order);

    /**
     * 手动取消订单
     * @param orderId
     */
    void handleCancelOrder(Long orderId);
}
