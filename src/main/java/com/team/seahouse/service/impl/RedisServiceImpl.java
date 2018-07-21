package com.team.seahouse.service.impl;

import com.team.seahouse.domain.dto.RedisKeyDto;
import com.team.seahouse.domain.vo.SmsCodeVo;
import com.team.seahouse.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @title Redis业务层接口实现
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Service
public class RedisServiceImpl<Object> implements IRedisService<Object> {

    @Resource
    protected RedisTemplate<String, Object> redisTemplate;

    @Resource
    protected HashOperations<String, String, Object> hashOperations;

    @Value("${spring.redis.key}")
    private String REDIS_KEY;

    /**
     * 存入redis中的key
     *
     * @return
     */
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }

    /**
     * 添加
     *
     * @param key    key
     * @param domain 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    @Override
    public void put(String key, Object domain, long expire) {
        hashOperations.put(getRedisKey(), key, domain);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    @Override
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    @Override
    public Object get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    @Override
    public List<Object> getAll() {
        return hashOperations.values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    @Override
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    @Override
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    @Override
    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     */
    @Override
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(), key));
    }
}
