package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.enums.TimeRangeEnum;
import com.team.seahouse.commons.utils.DateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 预约信息实体类
 * @describe 预约信息实体类
 * @author vanguard
 * @version 1.0
 * @date 18/7/20
 */
@Table(name = "tb_reservation")
@Getter@Setter
public class UserReservationVo extends BaseDomain {

    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 房屋照片
     */
    private String roomImage;

    /**
     * 房屋标题
     */
    private String title;

    @JsonIgnore
    private String houseName;

    @JsonIgnore
    private String roomName;

    /**
     * 房屋地址
     */
    private String address;

    /**
     * 地址坐标
     */
    private String addressCoordinate;

    /**
     * 房屋租金
     */
    private BigDecimal rent;

    /**
     * 房东编号
     */
    private Long landlordId;

    /**
     * 房东姓名
     */
    private String landlordName;

    /**
     * 房东手机号
     */
    private String landlordMobilePhone;

    /**
     * 房东头像
     */
    private String landlordAvatar;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 预约手机号
     */
    private String mobilePhone;

    /**
     * 用户性别
     * 0:女
     * 1:男
     */
    private Integer sex;

    /**
     * 预约日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String reservationDate;

    /**
     * 预约日期星期
     */
    private String reservationWeek;

    /**
     * 时间段
     */
    private Integer timeRange;

    private String timeRangeValue;

    /**
     * 预约状态
     */
    private Integer state;

    /**
     * 留言
     */
    private String message;

    public void setReservationDate(String reservationDate) {
        this.reservationDate = DateUtils.parseReservationDate(reservationDate);
        this.reservationWeek = DateUtils.dateToWeek(reservationDate);
    }

    public String getTitle() {
        return houseName + " " + roomName;
    }

    public String getTimeRangeValue() {
        return TimeRangeEnum.stateOf(timeRange).getStateInfo();
    }

    public String[] getAddressCoordinate() {
        return addressCoordinate.split(",");
    }

}
