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
     * @param phoneName
     * @return
     */
    String sendMessage(String phoneName);

    /**
     * 判断验证码是否正确
     * @param phone
     * @param code
     * @return
     */
    boolean checkIsCorrectCode(String phone,String code);
}
