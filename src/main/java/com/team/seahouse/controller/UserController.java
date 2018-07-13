package com.team.seahouse.controller;

import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author vanguard
 * @version 1.0
 * @describe
 * @date 2018/07/09
 */
@RestController
@RequestMapping("/pass")
@Api(value = "用户接口", description = "用户模块api接口，包含查看用户信息、修改信息等")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private IUserService userService;

    /**
     * 获得用户信息
     * @return
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Response login(HttpServletRequest request) {
        final String token = request.getHeader(tokenHeader);
        UserInfo userInfo = userService.findByToken(token);
        if(userInfo == null) {
            return new Response(CommonReturnCode.BAD_REQUEST);
        }
        return new Response(CommonReturnCode.OK, userInfo);
    }
}
