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
 * @title 足迹实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/19
 */
@Entity
@Table(name = "tb_track")
@Getter@Setter
public class Track extends BaseDomain {

    /**
     * 足迹编号
     */
    @Id
    @GeneratedValue
    private Long trackId;

    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 访问时间
     */
    private Date createTime;
}
