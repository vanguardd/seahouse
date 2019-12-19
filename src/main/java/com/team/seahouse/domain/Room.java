package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.mapper.typehandler.StringArrayTypeHandler;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.ColumnType;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * @Title: 房间实体类
 * @Description: 一个房屋对应多个房间
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/9/7
 */
@Data
@Table(name = "tb_room")
public class Room extends BaseDomain {

    /**
     * 房屋Id
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 房间名称
     */
    @Column(name = "room_name")
    private String roomName;

    /**
     * 房间面积
     */
    @Column(name = "room_area")
    private Double roomArea;

    /**
     * 房间设施
     */
    @Column(name = "room_facilities")
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] roomFacilities;

    /**
     * 房间照片（首页）
     */
    @Column(name = "room_image")
    private String roomImage;

    /**
     * 房间照片
     */
    @Column(name = "room_images")
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] roomImages;

    /**
     * 朝向
     */
    private String exposition;

    /**
     * 租金
     */
    private BigDecimal rent;

    /**
     * 支付方式
     */
    @Column(name = "pay_way")
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] payWay;

    /**
     * 租住方式
     */
    @Column(name = "rent_way")
    private String rentWay;

    /**
     * 标签
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] labels;

    /**
     * 房间介绍
     */
    private String introduction;

    /**
     * 最短租住期限
     */
    @Column(name = "date_limit")
    private String dateLimit;

    /**
     * 押金方式
     */
    private String deposit;

    /**
     * 房间状态
     * 1-正常、2-已租、3-已下架
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}