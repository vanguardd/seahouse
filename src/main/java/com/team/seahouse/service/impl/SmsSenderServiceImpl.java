package com.team.seahouse.service.impl;

import com.team.seahouse.domain.dto.RedisKeyDto;
import com.team.seahouse.domain.vo.SmsCodeVo;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    /**
     * 短信验证码过期时间
     */
    @Value("${sms.expireTime}")
    private Integer expireTime;

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
       /* try {
            URL targetURL = new URL(this.host);
            HttpURLConnection conn  = (HttpURLConnection) targetURL.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            StringBuilder sb = new StringBuilder(120);
            sb.append("username=").append(username);
            sb.append("&password=").append(password);
            sb.append("&apiKey=").append(apiKey);
            sb.append("&mobile=").append(phoneNumber);
            sb.append("&content=").append("您的验证码为:").append(code).append(",三分钟内输入有效！");
            conn.getOutputStream().write(sb.toString().getBytes());
            String responseText = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("UTF-8"));
            //短信发送成功
            if(responseText.contains("success")){
                SmsCodeVo smsCodeVo = new SmsCodeVo();
                smsCodeVo.setMobilePhone(phoneNumber);
                smsCodeVo.setValidateCode(code);
                smsCodeVo.setSendTime(new Date());

                RedisKeyDto redisKeyDto=new RedisKeyDto();
                redisKeyDto.setKeys(phoneNumber);
                redisKeyDto.setValues(smsCodeVo);
                redisService.addRedisData(redisKeyDto, EXPIRATIONTIME);
                return responseText;
            } else {
                throw new BusinessException(CommonReturnCode.SEND_MESSAGE_FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(CommonReturnCode.SEND_MESSAGE_FAILED);
        }*/
        StringBuilder sb = new StringBuilder(120);
        sb.append("username=").append(username);
        sb.append("&password=").append(password);
        sb.append("&apiKey=").append(apiKey);
        sb.append("&mobile=").append(phoneNumber);
        sb.append("&content=").append("您的验证码为:").append(code).append(",三分钟内输入有效！");

        SmsCodeVo smsCodeVo = new SmsCodeVo();
        smsCodeVo.setMobilePhone(phoneNumber);
        smsCodeVo.setValidateCode(code);
        smsCodeVo.setSendTime(new Date());

        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(phoneNumber);
        redisKeyDto.setValues(smsCodeVo);
        redisService.put(redisKeyDto.getKeys(), smsCodeVo, expireTime);
        return sb.toString();
    }

    @Override
    public boolean checkIsCorrectCode(String phone, String code) {
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(phone);
        SmsCodeVo result= (SmsCodeVo) redisService.get(redisKeyDto.getKeys());
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