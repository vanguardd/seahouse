package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Order;
import com.team.seahouse.domain.vo.ContractInfoVo;
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
    @Select("SELECT * FROM tb_order WHERE user_id=#{userId}")
    List<Order> findByUserId(@Param("userId") Long userId);

    /**
     * 获得签约信息
     * @param houseId
     * @param userId
     * @return
     */
    ContractInfoVo getContractInfo(@Param("houseId") Long houseId, @Param("userId") Long userId);
}