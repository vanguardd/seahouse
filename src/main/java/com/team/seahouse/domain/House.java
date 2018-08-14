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

    /******* 认证材料 1、房产证 type=1***********/
    /**
     * 房产证照片
     */
    private String propertyCardImages;

    /**
     * 房产证号
     */
    private String propertyCardId;

    /**
     * 房地产权人
     */
    private String propertyCarder;

    /**
     * 房屋使用起始日期
     */
    private Date startDate;

    /******* 认证材料 2、租赁合同 type=2*******/

    /**
     * 租赁合同照片
     */
    private String leaseContractImages;


    /**************公共空间配置**************/
    /**
     * 客厅
     */
    private String drawingRoom;

    /**
     * 卫生间
     */
    private String bathRoom;

    /**
     * 餐厅
     */
    private String diningRoom;

    /**
     * 阳台
     */
    private String balcony;

    /***************物业&水电费等***********/

    /**
     * 物业费
     */
    private BigDecimal propertyFee;

    /**
     * 物业费单位
     */
    private String propertyFeeType;

    /**
     * 水费
     */
    private BigDecimal waterFee;

    /**
     * 水费单位
     */
    private String waterFeeType;

    /**
     * 电费
     */
    private BigDecimal electricFee;

    /**
     * 电费单位
     */
    private String electricFeeType;

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
    private Integer floors;

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
     * 房间设施
     */
    private String roomFacilities;

    /**
     * 房间照片
     */
    private String roomImages;

    /**
     * 朝向
     */
    private String exposition;

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

    /****************地址信息**********************/

    /**
     * 详细地址
     */
    private String address;

    /**
     * 地址坐标
     */
    private String addressCoordinate;


    /**
     * 一级地址
     */
    private String firstAddress;

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
    private String introduction;

    /***************租住规则********************/

    /**
     * 租住规则
     */
    private String rentRule;

    /**
     * 退租规则
     */
    private String exitRentRule;

    /**
     * 房屋配置
     */
    private String disposition;

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
    private Integer state;

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
}
