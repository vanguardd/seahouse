package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 会员实体
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Entity
@Table(name = "tb_member")
@Getter@Setter
public class Member extends BaseDomain {

    /**
     * 会员编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 会员类型
     */
    private String memType;

    /**
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 到期时间
     */
    private Date endTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
