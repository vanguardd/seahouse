package com.team.seahouse.service;

import java.util.List;
import java.util.Set;

/**
 * @title
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 2018/07/16
 */
public interface IRedisService<T> {

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire);

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key);

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key);

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll();

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys();

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key);

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count();

    /**
     * 清空redis
     */
    public void empty();
}

