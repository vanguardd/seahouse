package com.team.seahouse.repository;

import com.team.seahouse.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @title 用户信息模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    UserInfo findByUserId(Long userId);

    /**
     * 根据用户编号更新头像
     * @param avatarPath
     * @param userId
     * @return
     */
    @Query("update UserInfo set avatar=:avatarPath where userId=:userId")
    int setAvatar(@Param("avatarPath") String avatarPath, @Param("userId") Long userId);

    /**
     * 根据用户编号更新昵称
     * @param userName
     * @param userId
     * @return
     */
    @Query("update UserInfo set userName=:userName where userId=:userId")
    int setUserName(@Param("userName") String userName, @Param("userId") Long userId);

}
