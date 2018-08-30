package com.team.seahouse.service;

import java.util.Collection;
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
     * 将对象value关联至key
     *
     * @param key
     * @param value
     */
    public void set(String key, T value);

    /**
     * 将对象value关联至key,并设置过期时间
     *
     * @param key
     * @param value
     * @param second
     */
    public void set(String key, T value, Long second);

    /**
     * 获得key为key的value
     *
     * @param key
     * @return
     */
    public T get(String key);

    /**
     * 是否存在key的value
     *
     * @param key
     * @return
     */
    public Boolean exists(String key);

    /**
     * 设置key的过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, Long seconds);

    /**
     * 删除key对应的数据
     *
     * @param key
     */
    public void del(String key);

    /**
     * 在hash表中添加数据
     *
     * @param key    key
     * @param field
     * @param object 对象
     */
    public void hput(String key, String field, T object);

    /**
     * hash表查询
     *
     * @param key
     * @param field
     * @return
     */
    public T hget(String key, String field);

    /**
     * 删除hash表key和field对应的数据
     *
     * @param key
     * @param field
     */
    public void hdel(String key, String... field);

    /**
     * 查询hash表中key的所有对象
     *
     * @param key
     * @return
     */
    public List<T> hvals(String key);

    /**
     * 查询hash表中key的所有field
     *
     * @param key
     * @return
     */
    public Set<String> hkeys(String key);

    /**
     * hash表key中，是否存在给定field值
     *
     * @param key   存入的key值
     * @param field 存入的field
     * @return
     */
    public boolean hexists(String key, String field);

    /**
     * 查询hash表key的数量
     *
     * @param key
     * @return
     */
    public long count(String key);

    /**
     * 清空redis
     */
    public void empty(String key);

    /**
     * 向list的头部插入value
     *
     * @param key
     * @param value
     */
    public void leftPush(String key, T value);

    /**
     * 向list的头部插入所有的value
     *
     * @param key
     * @param values
     */
    public void leftPushAll(String key, Collection<T> values);

    /**
     * 向list的尾部插入元素value
     *
     * @param key
     * @param value
     */
    public void rightPush(String key, T value);

    /**
     * 向list的尾部插入所有元素values
     *
     * @param key
     * @param values
     */
    public void rightPushAll(String key, Collection<T> values);

    /**
     * 获取指定key的list中从start到end的元素值
     *
     * @param key
     * @param start 大于0
     * @param end   -1：尾部，-2：倒数第二
     * @return
     */
    public List<T> range(String key, int start, int end);

    /**
     * 获取指定key的list的长度
     * @param key
     * @return
     */
    public Long size(String key);

    /**
     * 删除指定key的list中count个值为value的元素
     * @param key
     * @param count
     * @param value
     */
    public void remove(String key, int count, T value);

    /**
     *
     * @param key
     * @param start
     * @param end
     */
    public void trim(String key, int start, int end);


}