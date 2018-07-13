package com.team.seahouse.commons.auth;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.security.*;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public Response createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) {
        try {
            final String token = authService.login(authenticationRequest.getLoginName(), authenticationRequest.getPassword());
            // Return the token
            return new Response(CommonReturnCode.OK ,new JwtAuthenticationResponse(token));
        } catch(ValidateException e) {
            LoggerUtils.error(AuthController.class, e.getMessage(), e);
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public Response refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return new Response(CommonReturnCode.UNAUTHORIZED);
        } else {
            return new Response(CommonReturnCode.OK ,new JwtAuthenticationResponse(refreshedToken));
        }
    }

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
