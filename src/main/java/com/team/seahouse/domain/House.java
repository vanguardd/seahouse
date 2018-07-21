package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 房屋实体
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Entity
@Table(name = "tb_house")
@Getter@Setter
public class House extends BaseDomain {
    /**
     * 房屋编号
     */
    @Id
    @GeneratedValue
    private Long houseId;

    /**
     * 房屋标题
     */
    private String title;

    /**
     * 轮播图片
     */
    private String images;

    /**
     * 一级地址
     */
    private String firstAddress;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 租房方式
     */
    private String rentWay;

    /**
     * 房屋格局
     */
    private String housePattern;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 地址坐标
     */
    private String addressCoordinate;

    /**
     * 标签
     */
    private String tags;

    /**
     * 房屋配置
     */
    private String disposition;

    /**
     * 面积
     */
    private Double area;

    /**
     * 朝向
     */
    private String exposition;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 管家编号
     */
    private Long houseKeeperId;

    /**
     * 房东编号
     */
    private Long landlordId;

    /**
     * 房东姓名
     */
    private String landlordName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 审核状态
     */
    private Integer auditState;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private Long auditor;
}
