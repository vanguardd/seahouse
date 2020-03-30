package com.team.seahouse.commons.auth;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.JwtAuthResponse;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.request.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @title Auth验证控制器
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/17
 */
@Slf4j
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
            log.error(e.getMessage(), e);
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
            return new Response(CommonReturnCode.OK, token);
        } catch(ValidateException e) {
            log.error(e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }


    /**
     * 根据refreshToken刷新accessToken
     * @return
     */
    @ApiOperation(value = "刷新Token接口", notes = "刷新Token接口")
    @GetMapping("${jwt.route.authentication.refresh}")
    public Response refreshAndGetAuthenticationToken() {
        try {
            String refreshToken = getToken();
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
    @PostMapping(value = "${jwt.route.authentication.register}")
    public Response register(@RequestBody UserVo userVo) {
        try {
            JwtAuthResponse response = authService.register(userVo);
            return new Response(CommonReturnCode.OK, response);
        } catch(ValidateException e) {
            log.error(e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
