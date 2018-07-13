package com.team.seahouse.commons.exception;

import com.team.seahouse.commons.response.ReturnCode;

/**
 * @title ValidateException 异常类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
public class ValidateException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	/** 返回状态码 */
	private Integer code;
	
	public ValidateException() {
		super();
	}
	
	public ValidateException(String message) {
		super(message);
	}
	
	public ValidateException(Throwable cause) {
		super(cause);
	}
	
	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ValidateException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	
	public ValidateException(ReturnCode returnCode) {
		super(returnCode.getMessage());
		this.code = returnCode.getStatus();
	}
	
	public ValidateException(ReturnCode returnCode, Throwable cause) {
		super(returnCode.getMessage(), cause);
		this.code = returnCode.getStatus();
	}
	
	public ValidateException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
