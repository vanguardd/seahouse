package com.team.seahouse.repository;

import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.UserInfoVo;
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

    public String baseSql = "select u.userId as userId, u.userName as userName, u.avatar as avatar, " +
            "u.bornDate as bornDate, u.companyAddress as companyAddress, u.email as email, u.mobilePhone as mobilePhone, " +
            "u.realName as realName, u.sex as sex, z.zmScore as zmScore from UserInfo u, ZhiMaAuth z " +
            "where u.userId=z.userId";

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

    /**
     * 根据用户编号查询用户信息包括基本信息和芝麻信用分等
     * @param userId
     * @return
     */
    @Query(baseSql + " and u.userId=:userId")
    UserInfoVo findUserInfoByUserId(@Param("userId") Long userId);

}
