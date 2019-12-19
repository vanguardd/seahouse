package com.team.seahouse.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 预约信息实体类
 * @describe 预约信息实体类
 * @author vanguard
 * @version 1.0
 * @date 18/7/20
 */
@Data
@Table(name = "tb_reservation")
public class Reservation extends BaseDomain {

    /**
     * 房屋编号
     */
    private Long houseId;

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
     * 预约日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reservationDate;

    /**
     * 预约信息状态
     */
    private Integer state;

    /**
     * 时间段
     */
    private Integer timeRange;

    /**
     * 留言
     */
    private String message;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
