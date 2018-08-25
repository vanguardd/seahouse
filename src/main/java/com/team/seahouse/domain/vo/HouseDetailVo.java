package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: 房屋详情 图对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/21
 */
@Getter@Setter
public class HouseDetailVo extends BaseDomain {
    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 房屋标题
     */
    private String title;

    /**************公共空间配置**************/

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 客厅
     */
    private String livingRoom;

    private String livingRoomImages;

    /**
     * 卫生间
     */
    private String bathRoom;

    private String bathRoomImages;

    /**
     * 餐厅
     */
    private String kitchen;

    private String kitchenImages;

    /**
     * 阳台
     */
    private String balcony;

    private String balconyImages;

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
    private String roomFacilities;

    /**
     * 详情首页照片
     */
    private String roomImage;


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

    private String labels;

    private String introduction;

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
    private String villageIntroduction;

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
     * 房屋类型1：整租,2:合租
     */
    private Integer type;

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
     * 房东手机号
     */
    private String landLardMobilePhone;

    /**
     * 房东注册时间
     */
    private Date landLardCreateDate;

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
    }
}


