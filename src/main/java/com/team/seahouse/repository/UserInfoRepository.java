package com.team.seahouse.repository;

import com.team.seahouse.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/13
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    UserInfo findByUserId(Long userId);
}
