package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Title: 搜索封装类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/23
 */
@Getter@Setter
public class QueryVo extends BaseDomain {
    /**
     * 搜索关键字
     */
    private String keyWord;

    /**
     * 最小价格
     */
    private BigDecimal minPrice;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 标签
     */
    private String tags;

    /**
     * 朝向
     */
    private String exposition;
}
