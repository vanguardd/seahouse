package com.team.seahouse.service;

import com.team.seahouse.domain.Dto.RedisKeyDto;
import com.team.seahouse.domain.Vo.ValidateCodeVo;

/**
 * @title
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 2018/07/16
 */
public interface IRedisService {
    /**
     * Redis中添加数据
     * @param redisKeyDto
     */
    void addData(RedisKeyDto redisKeyDto);

    /**
     * Redis中删除数据
     * @param redisKeyDto
     */
    void delete(RedisKeyDto redisKeyDto);

    /**
     * 根据key获取Redis的值
     * @param redisKeyDto
     * @return
     */
    ValidateCodeVo redisGet(RedisKeyDto redisKeyDto);

    /**
     * Redis中添加有过期时间的数据
     * @param redisKeyDto
     * @param outTime
     */
    void addRedisData(RedisKeyDto redisKeyDto, int outTime);
}
