package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;

/**
 * @title 用户模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE user_name=#{userName}")
    User findByUserName(@Param("userName") String userName);

    /**
     * 根据手机号查询用户信息
     * @param mobilePhone
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE mobile_phone=#{mobilePhone}")
    User findByMobilePhone(@Param("mobilePhone") String mobilePhone);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE email=#{email}")
    User findByEmail(@Param("email") String email);

    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE id=#{userId}")
    User findByUserId(@Param("userId") Long userId);

    /**
     * 根据用户编号更新昵称
     * @param userName
     * @param userId
     * @return
     */
    @Update("UPDATE tb_user SET user_name=#{userName} WHERE id=#{userId}")
    int setUsername(@Param("userName") String userName, @Param("userId") Long userId);
}
