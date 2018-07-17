package com.team.seahouse.domain.dto;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/16
 */
@Getter@Setter
public class RedisKeyDto extends BaseDomain {

    /**
     * 键
     */
    private String keys;

    /**
     * 值
     */
    private Object values;
}