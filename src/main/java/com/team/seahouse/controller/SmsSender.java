package com.team.seahouse.controller;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.vo.SmsCodeVo;
import com.team.seahouse.service.ISmsSenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/sendMessage/{mobilePhone}")
    @ApiOperation(value = "发送短信验证码的接口", notes = "发送短信验证码的接口")
    public Response sendMessage(@PathVariable("mobilePhone") String mobilePhone) {
        try {
            smsSenderService.sendMessage(mobilePhone);
        } catch (BusinessException e) {
            LoggerUtils.error(SmsSender.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK);
    }

    @PostMapping("/checkSmsCode")
    @ApiOperation(value = "校验短信验证码", notes = "校验短信验证码")
    public Response checkSmsCode(@RequestBody SmsCodeVo smsCodeVo) {
        boolean isCorrectCode = smsSenderService.checkIsCorrectCode(smsCodeVo.getMobilePhone(), smsCodeVo.getValidateCode());
        if(!isCorrectCode) {
            return new Response(UserReturnCode.REGISTER_CODE_ERROR);
        }
        return new Response(CommonReturnCode.SUCCESS);
    }
}
