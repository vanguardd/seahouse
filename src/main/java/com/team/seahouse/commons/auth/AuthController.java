package com.team.seahouse.commons.auth;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.security.*;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.User;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/12
 */
@RestController
public class AuthController extends BaseController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private IAuthService authService;

    @Autowired
    private ISmsSenderService smsSenderService;

    /**
     * 用户名、密码登录接口
     * @param authenticationRequest
     * @return
     */
    @PostMapping("${jwt.route.authentication.password.login}")
    public Response createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) {
        try {
            final String token = authService.login(authenticationRequest.getUserName(), authenticationRequest.getPassword());
            // Return the token
            return new Response(CommonReturnCode.OK ,new JwtAuthenticationResponse(token));
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 手机号、验证码登录接口
     * @param mobilePhone
     * @param validateCode
     * @return
     */
    @PostMapping("${jwt.route.authentication.mobilePhone.login}")
    public Response createAuthenticationToken2(String mobilePhone, String validateCode) {
        try {
            final String token = authService.login(mobilePhone, validateCode);
            return new Response(CommonReturnCode.OK, token);
        } catch (ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 刷新Token
     * @return
     */
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public Response refreshAndGetAuthenticationToken() {
        String token = getRequest().getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return new Response(CommonReturnCode.UNAUTHORIZED);
        } else {
            return new Response(CommonReturnCode.OK ,new JwtAuthenticationResponse(refreshedToken));
        }
    }

    /**
     * 注册
     * @param addedUser
     * @return
     */
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public Response register(@RequestBody User addedUser) {
        try {
            User user = authService.register(addedUser);
            return new Response(CommonReturnCode.OK, user);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
