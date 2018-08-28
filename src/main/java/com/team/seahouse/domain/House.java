package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.mapper.typehandler.StringArrayTypeHandler;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.TypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 房屋实体
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Table(name = "tb_house")
@Getter@Setter
public class House extends BaseDomain {

    /**
     * 房屋标题
     */
    private String title;

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

    /**
     * 房屋使用起始日期
     */
    private Date startDate;

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
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] roomFacilities;

    /**
     * 详情首页照片
     */
    private String roomImage;


    /**
     * 房间照片
     */
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
     * 租房方式
     */
    private String rentWay;

    /**
     * 支付方式
     */
    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] payWay;

    @ColumnType(typeHandler = StringArrayTypeHandler.class)
    private String[] labels;

    private String introduction;

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

    /*public void setPropertyCardImages(String[] propertyCardImages) {
        this.propertyCardImages = StringUtils.arrayToString(propertyCardImages);;
    }

    public void setLeaseContractImages(String[] leaseContractImages) {
        this.leaseContractImages = StringUtils.arrayToString(leaseContractImages);
    }

    public void setLivingRoom(String[] livingRoom) {
        this.livingRoom = StringUtils.arrayToString(livingRoom);
    }

    public void setLivingRoomImages(String[] livingRoomImages) {
        this.livingRoomImages = StringUtils.arrayToString(livingRoomImages);
    }

    public void setBathRoom(String[] bathRoom) {
        this.bathRoom = StringUtils.arrayToString(bathRoom);
    }

    public void setBathRoomImages(String[] bathRoomImages) {
        this.bathRoomImages = StringUtils.arrayToString(bathRoomImages);
    }

    public void setKitchen(String[] kitchen) {
        this.kitchen = StringUtils.arrayToString(kitchen);
    }

    public void setKitchenImages(String[] kitchenImages) {
        this.kitchenImages = StringUtils.arrayToString(kitchenImages);
    }

    public void setBalcony(String[] balcony) {
        this.balcony = StringUtils.arrayToString(balcony);
    }

    public void setBalconyImages(String[] balconyImages) {
        this.balconyImages = StringUtils.arrayToString(balconyImages);
    }

    public void setRoomFacilities(String[] roomFacilities) {
        this.roomFacilities = StringUtils.arrayToString(roomFacilities);
    }

    public void setRoomImages(String[] roomImages) {
        this.roomImages = StringUtils.arrayToString(roomImages);
    }

    public void setPayWay(String[] payWay) {
        this.payWay = StringUtils.arrayToString(payWay);
    }

    public void setLabels(String[] labels) {
        this.labels = StringUtils.arrayToString(labels);
    }

    public void setAddressCoordinate(String[] addressCoordinate) {
        this.addressCoordinate = StringUtils.arrayToString(addressCoordinate);
    }

    public void setRentRule(String[] rentRule) {
        this.rentRule = StringUtils.arrayToString(rentRule);
    }

    public void setExitRentRule(String[] exitRentRule) {
        this.exitRentRule = StringUtils.arrayToString(exitRentRule);
    }

    public String[] getPropertyCardImages() {
        if(propertyCardImages != null) {
            return propertyCardImages.split(",");
        }
        return null;
    }

    public String[] getLeaseContractImages() {
        if(leaseContractImages != null) {
            return leaseContractImages.split(",");
        }
        return null;
    }

    public String[] getLivingRoom() {
        if(livingRoom != null) {
            return livingRoom.split(",");
        }
        return null;
    }

    public String[] getLivingRoomImages() {
        if(livingRoomImages != null) {
            return livingRoomImages.split(",");
        }
        return null;
    }

    public String[] getBathRoom() {
        if(bathRoom != null) {
            return bathRoom.split(",");
        }
        return null;
    }

    public String[] getBathRoomImages() {
        return bathRoomImages.split(",");
    }

    public String[] getKitchen() {
        return kitchen.split(",");
    }

    public String[] getKitchenImages() {
        return kitchenImages.split(",");
    }

    public String[] getBalcony() {
        return balcony.split(",");
    }

    public String[] getBalconyImages() {
        return balconyImages.split(",");
    }

    public String[] getRoomFacilities() {
        return roomFacilities.split(",");
    }

    public String[] getRoomImages() {
        return roomImages.split(",");
    }

    public String[] getPayWay() {
        return payWay.split(",");
    }

    public String[] getLabels() {
        return labels.split(",");
    }

    public String[] getAddressCoordinate() {
        return addressCoordinate.split(",");
    }

    public String[] getRentRule() {
        return rentRule.split(",");
    }

    public String[] getExitRentRule() {
        return exitRentRule.split(",");
    }*/
}
