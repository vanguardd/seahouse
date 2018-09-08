package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Title: 创建订单需要的信息
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/06
 */
@Getter@Setter
public class HouseInfoVo extends BaseDomain {
    /**
     * 房屋标题
     */
    private String title;

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 物业费
     */
    private BigDecimal propertyValue;

    /**
     * 物业费单位
     */
    private String propertyPayType;

    /**
     * 水费
     */
    private BigDecimal waterValue;

    /**
     * 水费单位
     */
    private String waterPayType;

    /**
     * 电费
     */
    private BigDecimal electricValue;

    /**
     * 电费单位
     */
    private String electricPayType;

    /**
     * 暖气费
     */
    private BigDecimal heatingValue;

    /**
     * 暖气费单位
     */
    private String heatingPayType;

    /**
     * 自定义费用名称
     */
    private String customName;

    /**
     * 自定义费用值
     */
    private BigDecimal customValue;

    /**
     * 自定义费用单位
     */
    private String customPayType;

    /**
     * 装修程度
     */
    private String fixtures;

    /**
     * 房屋格局
     */
    private String housePattern;

    /**
     * 房间面积
     */
    private Double roomArea;

    /**
     * 详情首页照片
     */
    private String roomImage;

    /**
     * 租金
     */
    private BigDecimal rent;

    /**
     * 租房方式
     */
    private String rentWay;

    /**
     * 房东编号
     */
    private Long landlordId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idNumber;
}
