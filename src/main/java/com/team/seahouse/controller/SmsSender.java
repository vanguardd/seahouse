package com.team.seahouse.controller;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.service.ISmsSenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 发送短信接口
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@RestController
@RequestMapping("/sms")
@Api(value = "发送短信验证码接口", description = "发送短信验证码的接口")
public class SmsSender {

    @Autowired
    private ISmsSenderService smsSenderService;

    @PostMapping("/sendMessage")
    @ApiOperation(value = "发送短信验证码的接口", notes = "发送短信验证码的接口")
    public Response sendMessage(String mobilePhone) {
        try {
            smsSenderService.sendMessage(mobilePhone);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK);
    }
}
