package com.team.seahouse.commons.response;

import com.team.seahouse.commons.response.ReturnCode;

/**
 * @title 用户返回码定义
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/10
 */
public enum UserReturnCode implements ReturnCode {
	
	USER_NOT_EXIST(1000, "该账号不存在!"),
	USER_SUSPEND(10001, "该账号已被冻结!"),
	WRONG_PASSWORD(10002, "您输入的密码不正确!"),
	ACCOUNT_LOCK(10004, "密码连续输入错误超过5次，锁定半小时!"),
	REGISTER_CODE_ERROR(10005, "验证码错误!"),
	ENTERED_PASSWORDS_DIFFER(10006, "两次输入的密码不一致"),
	PASSWORD_AUTHENTICATION_ERROR(10007, "密码长度8~16位，其中数字，字母和符号至少包含两种!"),
	ACCOUNT_NULL(10003, "手机号不能为空"),
	ACCOUNT_ERROR(10008, "该手机号已被注册，请登录!"),
	USERNAME_LENGTH_LIMIT(10009, "昵称超过最大长度"),
	USERNAME_SAME(10010, "昵称相同"),
	MOBILE_PHONE_NOT_EXIST(10011, "该手机号未注册，请注册后登录！"),
	SMS_CODE_EXIST(10012, "验证码已发送！"),
	USERNAME_EXIST(10013, "昵称已存在");
	
	/** 返回状态码 */
	private Integer status;

	/** 返回消息 */
	private String message;
	
	private UserReturnCode(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
