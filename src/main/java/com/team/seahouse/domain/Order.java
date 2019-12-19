package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
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
@Data
@Table(name = "tb_order")
public class Order extends BaseDomain {
    /**
     * 订单编号
     * 系统生成
     */
    private String orderNumber;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 租客签字状态 1-签字;0-未签字
     */
    @Column(name = "renter_sign_state")
    private Integer renterSignState;

    /**
     * 房东编号
     */
    @Column(name = "landLord_id")
    private Long landlordId;

    /**
     * 房东签字状态 1-签字;0-未签字
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
     * 租住期限
     */
    private String rentDateLimit;

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
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 交易时间
     */
    @Column(name = "business_time")
    private Date businessTime;
}