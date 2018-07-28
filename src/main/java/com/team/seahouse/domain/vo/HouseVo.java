package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: 房屋信息视图对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/24
 */
@Getter@Setter
public class HouseVo extends BaseDomain {
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
     * 房屋类型1：整租,2:合租
     */
    private Integer type;

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
     * 房东芝麻信用分
     */
    private Integer landLoardZhiMaScore;

    /**
     * 创建时间
     */
    private Date createTime;

}
