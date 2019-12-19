package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 芝麻信用认证实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/19
 */
@Data
@Table(name = "tb_zhiMa_auth")
public class ZhiMaAuth extends BaseDomain {

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 芝麻信用分
     */
    private Integer zmScore;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
