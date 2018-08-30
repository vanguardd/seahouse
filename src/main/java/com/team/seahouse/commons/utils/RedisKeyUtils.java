package com.team.seahouse.commons.utils;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/30
 */
public class RedisKeyUtils {


    /**
     * 生成redisKey
     * @param pre 前缀
     * @param key key
     * @return
     */
    public static String generateKeyWithPlaceHolder(String pre, Long key) {
        return pre + ":" + key;
    }

    /**
     * 生成redisKey
     * @param pre
     * @param key
     * @return
     */
    public static String generateKeyWithPlaceHolder(String pre, String key) {
        return pre + ":" + key;
    }
}
