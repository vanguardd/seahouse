package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/19
 */
@Data
@Table(name = "tb_collection")
public class Collections extends BaseDomain {

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
