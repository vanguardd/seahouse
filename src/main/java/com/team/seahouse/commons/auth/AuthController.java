package com.team.seahouse.commons.auth;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
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

    @Autowired
    private ISmsSenderService smsSenderService;


    /**
     * @title 登录接口
     * @describe 包括密码登录
     * @author vanguard
     * @version 1.0
     * @date 18/7/17
     */
    @ApiOperation(value = "登录接口", notes = "密码登录接口")
    @PostMapping("${jwt.route.authentication.password.login}")
    public Response createAuthenticationToken(@RequestBody JwtAuthVo jwtAuthVo) {
        try {
            final String token = authService.loginByPassword(jwtAuthVo.getUserName(), jwtAuthVo.getPassword());
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
    public Response createAuthenticationToken2(@RequestBody JwtAuthVo jwtAuthVo) {
        try {
            final String token = authService.loginBySmsCode(jwtAuthVo.getUserName(), jwtAuthVo.getPassword());
            // Return the token
            return new Response(CommonReturnCode.OK ,token);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }


    /**
     * 刷新Token
     * @return
     */
    @ApiOperation(value = "刷新Token接口", notes = "刷新Token接口")
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public Response refreshAndGetAuthenticationToken() {
        String token = getRequest().getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return new Response(CommonReturnCode.UNAUTHORIZED);
        } else {
            return new Response(CommonReturnCode.OK ,refreshedToken);
        }
    }

    /**
     * 注册
     * @param userVo
     * @return
     */
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public Response register(@RequestBody UserVo userVo) {
        try {
            User user = authService.register(userVo);
            return new Response(CommonReturnCode.OK, user);
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
