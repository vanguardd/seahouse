package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
