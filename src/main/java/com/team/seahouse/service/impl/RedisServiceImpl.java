package com.team.seahouse.service.impl;

import com.team.seahouse.domain.Dto.RedisKeyDto;
import com.team.seahouse.domain.Vo.ValidateCodeVo;
import com.team.seahouse.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @title Redis业务层接口实现
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate<String, ValidateCodeVo> redisTemplate;

    @Override
    public void addData(final RedisKeyDto redisKeyDto) {
        redisTemplate.opsForValue().set(redisKeyDto.getKeys(), redisKeyDto.getValues());
    }

    @Override
    public void delete(final RedisKeyDto redisKeyDto) {
        redisTemplate.delete(redisKeyDto.getKeys());
    }

    @Override
    public ValidateCodeVo redisGet(final RedisKeyDto redisKeyDto) {
        return redisTemplate.opsForValue().get(redisKeyDto.getKeys());
    }

    @Override
    public void addRedisData(final RedisKeyDto redisKeyDto, final int outTime) {
        redisTemplate.opsForValue().set(redisKeyDto.getKeys(), redisKeyDto.getValues(), outTime);
    }
}
