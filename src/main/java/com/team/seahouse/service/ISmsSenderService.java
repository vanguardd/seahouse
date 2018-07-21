package com.team.seahouse.service;

/**
 * @title 发送验证码业务接口
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
public interface ISmsSenderService {

    /***
     * 发送验证码
     * @param phoneNumber 手机号
     * @param type 发送验证码的类型：登录、注册、其他
     * @return
     */
    String sendMessage(String phoneNumber, String type);

    /**
     * 判断验证码是否正确
     * @param phone
     * @param code
     * @return
     */
    boolean checkIsCorrectCode(String phone, String code);
}
