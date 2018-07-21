package com.team.seahouse.commons.base;


import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.UserRepository;
import com.team.seahouse.service.IUserService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;

/**
 * @author vanguard
 * @version 1.0
 * @descripe BaseController 控制器基类
 * @date: 2018-02-09
 */
public class BaseController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private UserRepository userRepository;


	/**
	 * 获得HttpServletRequest
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
	}

	/**
	 * 根据请求携带的Token获得用户信息实体
	 * @return
	 */
	protected UserInfo getUserInfo() throws BusinessException {
		Long userId = getUserId();
		return userInfoRepository.findByUserId(userId);
	}

	/**
	 * 根据请求携带的Token获得用户实体
	 * @return
	 */
	protected User getUser() {
		  Long userId = getUserId();
		return userRepository.findByUserId(userId);
	}

	/**
	 * 根据请求携带的Token获得用户编号
	 * @return
	 * @throws BusinessException
	 */
	protected Long getUserId() throws BusinessException {
		final String tokenStr = getRequest().getHeader(tokenHeader);
		final String token = tokenStr.substring(tokenHead.length());
		Long userId = jwtTokenUtil.getUserIdFromToken(token);
		if(userId == null) {
			throw new ValidateException(CommonReturnCode.UNAUTHORIZED);
		}
		return userId;

	}
}
