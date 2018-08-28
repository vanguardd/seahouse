package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 足迹实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/19
 */
@Getter@Setter
@Table(name = "tb_track")
public class Track extends BaseDomain {

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
