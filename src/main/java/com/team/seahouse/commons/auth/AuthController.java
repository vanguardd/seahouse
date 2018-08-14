package com.team.seahouse.commons.auth;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.JwtAuthResponse;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.security.*;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.vo.JwtAuthVo;
import com.team.seahouse.domain.vo.UserVo;
import com.team.seahouse.service.ISmsSenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @title Auth验证控制器
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/17
 */
@Api(value = "Auth验证控制器", description = "Auth验证控制器")
@RestController
public class AuthController extends BaseController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private IAuthService authService;

    /**
     * @title 登录接口
     * @describe 包括密码登录
     * @author vanguard
     * @version 1.0
     * @date 18/7/17
     */
    @ApiOperation(value = "登录接口", notes = "密码登录接口")
    @PostMapping("${jwt.route.authentication.password.login}")
    public Response createAuthenticationToken(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        try {
            JwtAuthResponse token = authService.loginByPassword(userName, password);
            // Return the token
            return new Response(CommonReturnCode.OK ,token);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * @title 登录接口
     * @describe 短信验证码登录
     * @author vanguard
     * @version 1.0
     * @date 18/7/17
     */
    @ApiOperation(value = "登录接口", notes = "短信验证码登录接口")
    @PostMapping("${jwt.route.authentication.mobilePhone.login}")
    public Response createAuthenticationToken2(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("smsCode") String smsCode) {
        try {
            JwtAuthResponse token = authService.loginBySmsCode(mobilePhone, smsCode);
            // Return the token
            return new Response(CommonReturnCode.OK ,token);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }


    /**
     * 根据refreshToken刷新accessToken
     * @param refreshToken 刷新Token
     * @return
     */
    @ApiOperation(value = "刷新Token接口", notes = "刷新Token接口")
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public Response refreshAndGetAuthenticationToken(@RequestParam("refresh_token") String refreshToken) {
        try {
            JwtAuthResponse response = authService.refresh(refreshToken);
            return new Response(CommonReturnCode.OK, response);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 注册
     * @param userVo
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "手机号密码注册并自动登录")
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public Response register(@RequestBody UserVo userVo) {
        try {
            JwtAuthResponse response = authService.register(userVo);
            return new Response(CommonReturnCode.OK, response);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
