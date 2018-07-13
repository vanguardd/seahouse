package com.team.seahouse.controller;

import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vanguard
 * @version 1.0
 * @describe
 * @date 2018/07/09
 */
@RestController
@RequestMapping("/pass")
public class UserController {
    @RequestMapping("/login")
    public Object login() {
        String[] data = { "useranme", "password"};
        return new Response(CommonReturnCode.UNAUTHORIZED);
    }
}
