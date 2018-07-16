package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.domain.Dto.RedisKeyDto;
import com.team.seahouse.domain.Vo.ValidateCodeVo;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import javax.annotation.Resource;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/16
 */
@Service
public class SmsSenderServiceImpl implements ISmsSenderService {

    //短信验证码过期时间
    private  static int  EXPIRATIONTIME=3000;
    @Resource
    private IRedisService redisService;

    @Value("${sms.host}")
    private String host;
    @Value("${sms.username}")
    private String username;
    @Value("${sms.password}")
    private String password;
    @Value("${sms.apiKey}")
    private String apiKey;

    @Transactional
    @Override
    public String sendMessage(String phoneNumber) {
        System.out.println(host);
        String code = getRandNum(6);
        System.out.println("验证码是:" + code);
        //------------------------模拟发送短信
//		System.out.println("给" + phoneNumber + "发送的验证码为" +code);
        try {
            URL targetURL = new URL(this.host);
            HttpURLConnection conn  = (HttpURLConnection) targetURL.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            StringBuilder sb = new StringBuilder(120);
            sb.append("username=").append(username);
            sb.append("&password=").append(password);
            sb.append("&apikey=").append(apiKey);
            sb.append("&mobile=").append(phoneNumber);
            sb.append("&content=").append("您的验证码为:").append(code).append(",三分钟内输入有效！");
            conn.getOutputStream().write(sb.toString().getBytes());
            String responseText = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("UTF-8"));
            //短信发送成功
            if(responseText.contains("success")){
                ValidateCodeVo validateCodeVo = new ValidateCodeVo();
                validateCodeVo.setMobilePhone(phoneNumber);
                validateCodeVo.setValidateCode(code);
                validateCodeVo.setSendTime(new Date());

                RedisKeyDto redisKeyDto=new RedisKeyDto();
                redisKeyDto.setKeys(phoneNumber);
                redisKeyDto.setValues(validateCodeVo);
                redisService.addRedisData(redisKeyDto, EXPIRATIONTIME);
                return responseText;
            } else {
                throw new BusinessException(CommonReturnCode.SEND_MESSAGE_FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(CommonReturnCode.SEND_MESSAGE_FAILED);
        }
    }

    @Override
    public boolean checkIsCorrectCode(String phone, String code) {
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(phone);
        ValidateCodeVo result=redisService.redisGet(redisKeyDto);
        if (result!=null && result.getValidateCode().equals(String.valueOf(code))) {
            return true;
        }
        return false;
    }
    /***
     * 获取6位验证码
     * @param charCount
     * @return
     */
    public String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
}
