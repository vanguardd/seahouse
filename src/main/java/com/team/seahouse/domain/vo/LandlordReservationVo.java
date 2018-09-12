package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.enums.TimeRangeEnum;
import com.team.seahouse.commons.utils.DateUtils;
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
public class LandlordReservationVo extends BaseDomain {

    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 房屋照片
     */
    private String roomImage;

    /**
     * 房屋名称
     */
    @JsonIgnore
    private String houseName;

    /**
     * 房间名称
     */
    @JsonIgnore
    private String roomName;

    /**
     * 标题
     */
    private String title;

    /**
     * 房屋地址
     */
    private String address;

    /**
     * 房屋租金
     */
    private BigDecimal rent;

    /**
     * 房东编号
     */
    private Long landlordId;

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
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

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

}
