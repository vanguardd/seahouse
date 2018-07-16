package com.team.seahouse.repository;

import com.team.seahouse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/12
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
}
