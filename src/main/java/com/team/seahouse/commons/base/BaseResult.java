package com.team.seahouse.commons.base;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author vanguard
 * @version 1.0
 * @descripe BaseResult 统一返回结果类
 * @date: 2018-07-09
 */
@Getter@Setter
public class BaseResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 返回状态码 */
	private Integer status;
	
	/** 返回信息 */
	private String message;
	
	/** 返回数据 */
	private Object data;
	
	public BaseResult(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public BaseResult(Integer status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

}
