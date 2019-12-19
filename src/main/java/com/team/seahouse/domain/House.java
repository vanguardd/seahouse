package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.mapper.typehandler.StringArrayTypeHandler;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.TypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 合租房屋实体
 * @describe 房屋的公共信息，和房间为一对多
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Data
@Table(name = "tb_house")
public class House extends BaseDomain {

    /******* 认证材料 1、房产证 type=1***********/
    /**
     * 房产证照片
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] propertyCardImages;

    /**
     * 房产证号
     */
    private String propertyCardId;

    /**
     * 房地产权人
     */
    private String propertyCarder;

    /******* 认证材料 2、租赁合同 type=2*******/

    /**
     * 租赁合同照片
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] leaseContractImages;


    /**************公共空间配置**************/

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 客厅
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] livingRoom;

    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] livingRoomImages;

    /**
     * 卫生间
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] bathRoom;

    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] bathRoomImages;

    /**
     * 餐厅
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] kitchen;

    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] kitchenImages;

    /**
     * 阳台
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] balcony;

    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] balconyImages;

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


    /****************地址信息**********************/

    /**
     * 详细地址
     */
    private String address;

    /**
     * 地址坐标
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] addressCoordinate;


    /**
     * 区域
     */
    private String region;

    /***************小区信息**********************/

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 绿化面积
     */
    private Double greenArea;

    /**
     * 供暖方式
     */
    private String heatingWay;

    /**
     * 地下停车场
     */
    private String parking;

    /**
     * 物业公司
     */
    private String property;

    /**
     * 建筑年代
     */
    private String years;

    /**
     * 小区简介
     */
    private String villageIntroduction;

    /***************租住规则********************/

    /**
     * 租住规则
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] rentRule;

    /**
     * 退租规则
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] exitRentRule;

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
    private Integer landLardZhiMaScore;



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
     * 审核备注信息
     */
    private String remark;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private Long auditor;

    /**
     * 房间Id
     */
    @Transient
    private String roomIds;

    private void setRoomIds(String[] roomIds) {
        this.roomIds = StringUtils.arrayToString(roomIds);
    }
}
