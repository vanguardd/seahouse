package com.team.seahouse.commons.response;

import com.sun.org.apache.regexp.internal.RE;
import com.team.seahouse.commons.base.BaseResult;

/**
 * @title 统一响应结构
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/10
 */
public class Response extends BaseResult {

	public Response(ReturnCode returnCode) {
		super(returnCode.getCode(), returnCode.getMessage());
	}

	public Response(ReturnCode returnCode, Object data) {
		super(returnCode.getCode(), returnCode.getMessage(), data);
	}

}