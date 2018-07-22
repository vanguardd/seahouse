package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.CommonEnum;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.domain.User;
import com.team.seahouse.domain.vo.SmsCodeVo;
import com.team.seahouse.repository.UserRepository;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Long expireTime;

    @Value("${REDIS_SMS_PRE}")
    private String REDIS_SMS_PRE;

    @Resource
    private IRedisService<SmsCodeVo> redisService;

    @Autowired
    private UserRepository userRepository;

    @Value("${sms.host}")
    private String host;
    @Value("${sms.username}")
    private String username;
    @Value("${sms.password}")
    private String password;
    @Value("${sms.apiKey}")
    private String apiKey;


    @Transactional(rollbackFor = ValidateException.class)
    @Override
    public String sendMessage(String phoneNumber, String type) {
        User user = userRepository.findByMobilePhone(phoneNumber);
        if(CommonEnum.REGISTER_TYPE.getType().equals(type)) {
            if(user != null) {
                throw new ValidateException(UserReturnCode.ACCOUNT_ERROR);
            }
        }
        if(CommonEnum.LOGIN_TYPE.getType().equals(type)) {
            if(user == null) {
                throw new ValidateException(UserReturnCode.MOBILE_PHONE_NOT_EXIST);
            }
        }

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

        redisService.set(REDIS_SMS_PRE + ":" + phoneNumber, smsCodeVo, expireTime);
        return sb.toString();
    }

    @Override
    public boolean checkIsCorrectCode(String phone, String code) {
        //根据手机号获得存入redis中的验证码
        SmsCodeVo result= redisService.get(REDIS_SMS_PRE + ":" + phone);
        //校验验证码
        if(result != null && result.getValidateCode().equals(String.valueOf(code))) {
            //验证成功后，手动删除redis中的验证码
            redisService.del(REDIS_SMS_PRE + ":" + phone);
            return true;
        }
        return false;
    }
    /***
     * 获取6位验证码
     * @param charCount
     * @return
     */
    private String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    private int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
}
