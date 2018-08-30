package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.UserInfoVo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

/**
 * @title 用户信息模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    @Select("SELECT * FROM tb_user_info WHERE user_id=#{userId};")
    UserInfo findByUserId(Long userId);

    /**
     * 根据用户编号更新头像
     * @param avatarPath
     * @param userId
     * @return
     */
    @Update("UPDATE tb_user_info SET avatar=#{avatarPath} WHERE user_id=#{userId}")
    int setAvatar(@Param("avatarPath") String avatarPath, @Param("userId") Long userId);

    /**
     * 根据用户编号更新昵称
     * @param userName
     * @param userId
     * @return
     */
    @Update("UPDATE tb_user_info SET user_name=#{userName} WHERE user_id=#{userId}")
    int setUserName(@Param("userName") String userName, @Param("userId") Long userId);

    /**
     * 根据用户编号查询用户信息包括基本信息和芝麻信用分等
     * @param userId
     * @return
     */
    UserInfoVo findUserInfoByUserId(Long userId);

}
