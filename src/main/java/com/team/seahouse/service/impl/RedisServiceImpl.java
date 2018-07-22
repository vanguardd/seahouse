package com.team.seahouse.service.impl;

import com.team.seahouse.service.IRedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @title Redis业务层接口实现
 * @describe Redis业务层接口实现
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Service
public class RedisServiceImpl<Object> implements IRedisService<Object> {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ValueOperations<String, Object> valueOperations;

    @Resource
    private HashOperations<String, String, Object> hashOperations;


    @Override
    public void set(String key, Object value) {
        valueOperations.set(key, value);
    }

    @Override
    public void set(String key, Object value, Long second) {
        valueOperations.set(key, value, second, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return valueOperations.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void expire(String key, Long seconds) {
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void hput(String key, String field, Object object) {
        hashOperations.put(key, field, object);
    }

    @Override
    public Object hget(String key, String field) {
        return hashOperations.get(key, field);
    }

    @Override
    public List<Object> hvals(String key) {
        return hashOperations.values(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return hashOperations.keys(key);
    }

    @Override
    public void hdel(String key, String... field) {
        hashOperations.delete(key, field);
    }

    @Override
    public boolean hexists(String key, String field) {
        return hashOperations.hasKey(key, field);
    }

    @Override
    public long count(String key) {
        return hashOperations.size(key);
    }

    @Override
    public void empty(String key) {
        Set<String> set = hashOperations.keys(key);
        set.stream().forEach(hkey -> hashOperations.delete(key, hkey));
    }
}
