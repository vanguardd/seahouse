package com.team.seahouse.domain;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * @Title: 订单实体类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/8/31
 */
@Getter@Setter
@Table(name = "tb_order")
public class Order {
    /**
     * 订单编号
     */
    @Id
    private String id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 租客签字状态
     */
    @Column(name = "renter_sign_state")
    private Integer renterSignState;

    /**
     * 房东编号
     */
    @Column(name = "landLord_id")
    private Long landlordId;

    /**
     * 房东签字状态
     */
    @Column(name = "landLord_sign_state")
    private Integer landlordSignState;

    /**
     * 房屋编号
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 合同编号
     */
    @Column(name = "contract_id")
    private Long contractId;

    /**
     * 订单状态
     */
    private Integer state;

    /**
     * 支付方式
     */
    @Column(name = "pay_way")
    private Integer payWay;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 优惠金额
     */
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    /**
     * 交易金额
     */
    @Column(name = "business_amount")
    private BigDecimal businessAmount;

    /**
     * 租客签约时间
     */
    @Column(name = "renter_sign_time")
    private Date renterSignTime;

    /**
     * 房东签约时间
     */
    @Column(name = "landLord_sign_time")
    private Date landlordSignTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 交易时间
     */
    @Column(name = "business_time")
    private Date businessTime;
}