package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.TypeEnum;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.utils.RedisKeyUtils;
import com.team.seahouse.domain.User;
import com.team.seahouse.mapper.UserMapper;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ISmsSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/16
 */
@Slf4j
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
    private IRedisService<String> redisService;

    @Autowired
    private UserMapper userMapper;

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
    public void sendMessage(String phoneNumber, Integer type) {
        User user = userMapper.findByMobilePhone(phoneNumber);
        if(TypeEnum.REGISTER_TYPE.getType().equals(type)) {
            if(user != null) {
                throw new ValidateException(UserReturnCode.ACCOUNT_ERROR);
            }
        }
        if(TypeEnum.LOGIN_TYPE.getType().equals(type)) {
            if(user == null) {
                throw new ValidateException(UserReturnCode.MOBILE_PHONE_NOT_EXIST);
            }
        }
        //生成key
        String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_SMS_PRE, phoneNumber);
        boolean isExist = redisService.exists(key);
        log.info("host is" + host);
        String code = "";
        //该手机号验证码已经验证
        if(!isExist) {
            //生成验证码
            code = getRandNum(6);
            //存入redis中并设置过期时间
            redisService.set(key, code, expireTime);
        } else {
            code = redisService.get(key);
        }
        log.info("generate smsCode success : " + code);

        StringBuilder sb = new StringBuilder(120);
        sb.append("username=").append(username);
        sb.append("&password=").append(password);
        sb.append("&apiKey=").append(apiKey);
        sb.append("&mobile=").append(phoneNumber);
        sb.append("&content=").append("您的验证码为:").append(code).append(",三分钟内输入有效！");

        //发送验证码
        //TODO 发送验证码的实现
    }

    @Override
    public boolean checkIsCorrectCode(String phone, String code) {
        String key = RedisKeyUtils.generateKeyWithPlaceHolder(REDIS_SMS_PRE, phone);
        //根据手机号获得存入redis中的验证码
        String smsCode = redisService.get(key);
        //校验验证码
        if(smsCode != null && smsCode.equals(String.valueOf(code))) {
            //验证成功后，手动删除redis中的验证码
            redisService.expire(key, 1L);
            redisService.del(key);
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
