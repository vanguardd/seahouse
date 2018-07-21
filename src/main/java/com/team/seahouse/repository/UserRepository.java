package com.team.seahouse.repository;

import com.team.seahouse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @title 用户模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据手机号查询用户信息
     * @param mobilePhone
     * @return
     */
    User findByMobilePhone(String mobilePhone);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    User findByUserId(Long userId);

    /**
     * 根据用户编号更新昵称
     * @param userName
     * @param userId
     * @return
     */
    @Query("update User set userName=:userName where userId=:userId")
    int setUsername(String userName, Long userId);
}
