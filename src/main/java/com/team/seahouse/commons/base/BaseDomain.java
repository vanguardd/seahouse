package com.team.seahouse.commons.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Descripe 基础domain
 * @Author vanguard
 * @Date: 2018/01/31
 * @Version 1.0
 *
 */
@Setter@Getter
public class BaseDomain implements Serializable {

    protected static final long serialVersionUID = 1L;

    protected Long id;
}
