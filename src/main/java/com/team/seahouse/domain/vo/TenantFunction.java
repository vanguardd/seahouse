package com.team.seahouse.domain.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/09
 */
@Setter@Getter
public class TenantFunction {
    /**
     * 收藏个数
     */
    private Integer collectionCount;

    /**
     * 预约个数
     */
    private Integer reservationCount;

    /**
     * 足迹个数
     */
    private Integer trackCount;

    /**
     * 订单个数
     */
    private Integer orderCount;
}
