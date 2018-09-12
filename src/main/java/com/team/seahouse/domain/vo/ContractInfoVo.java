package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Title: 创建订单所需的信息
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/11
 */
@Getter@Setter
public class ContractInfoVo {

    private Long roomId;
    /**
     * 房屋标题
     */
    private String title;

    /**************公共空间配置**************/

    /**
     * 房屋名称
     */
    @JsonIgnore
    private String houseName;


    /***************物业&水电费等***********/

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

    /****************其他******************/

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 是否有电梯
     */
    private Boolean isHasElevator;

    /**
     * 装修程度
     */
    private String fixtures;

    /**
     * 房屋格局
     */
    private String housePattern;

    /******************房间信息*************/

    /**
     * 房间名称
     */
    private String roomName;

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
     * 支付方式
     */
    private String payWay;

    /**
     * 最短租房期限
     */
    private String dateLimit;

    /****************地址信息**********************/

    /**
     * 详细地址
     */
    private String address;

    /**
     * 一级地址
     */
    private String region;

    /**
     * 房东编号
     */
    private Long landlordId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件号
     */
    private String idNumber;

    public String getTitle() {
        return houseName + " " + roomName;
    }
}
