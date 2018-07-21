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
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/19
 */
@Entity
@Table(name = "tb_collection")
@Getter@Setter
public class Collection extends BaseDomain {

    /**
     * 收藏编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 房屋编号
     */
    private Long houseId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;
}
