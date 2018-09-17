package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Order;
import com.team.seahouse.domain.vo.ContractInfoVo;
import com.team.seahouse.domain.vo.OrderDetailVo;
import com.team.seahouse.domain.vo.OrderListVo;
import com.team.seahouse.domain.vo.TenantVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Title: 订单模块
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/9/8
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 根据用户编号查询订单列表
     * @param userId
     * @return
     */
    List<OrderListVo> findByUserId(@Param("userId") Long userId);

    /**
     * 获得签约信息
     * @param houseId
     * @param userId
     * @return
     */
    ContractInfoVo getContractInfo(@Param("houseId") Long houseId, @Param("userId") Long userId);

    /**
     * 查询房东的订单列表
     * @param userId
     * @return
     */
    List<OrderListVo> findLandlordByUserId(@Param("userId") Long userId);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderDetailVo findByOrderId(Long orderId);

    /**
     * 根据房东用户编号查询租客列表
     * @param userId
     * @return
     */
    List<TenantVo> findTenants(Long userId);

    /**
     * 根据房东用户编号查询租客个数
     * @param userId
     * @return
     */
    Long selectTenantCount(Long userId);
}