package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @title 预约信息实体类
 * @describe 预约信息实体类
 * @author vanguard
 * @version 1.0
 * @date 18/7/20
 */
@Entity
@Table(name = "tb_reservation")
@Getter@Setter
public class Reservation extends BaseDomain {
    /**
     * 预约编号
     */
    @Id
    @GeneratedValue
    private Long reservationId;

    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 房屋标题
     */
    private String title;

    /**
     * 房东编号
     */
    private Long landlordId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 预约时间
     */
    private Date reservationTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
