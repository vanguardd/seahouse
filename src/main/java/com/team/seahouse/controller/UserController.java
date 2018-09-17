package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.exception.ValidateException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.IdentityAuth;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.ZhiMaAuth;
import com.team.seahouse.domain.vo.LandlordFunction;
import com.team.seahouse.domain.vo.TenantFunction;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.mapper.UserInfoMapper;
import com.team.seahouse.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title 用户模块接口
 * @describe 用户模块接口
 * @author vanguard
 * @version 1.0
 * @date 18/7/14
 */
@RestController
@RequestMapping("/pass")
@Api(value = "用户接口", description = "用户信息接口")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 获得我的用户信息
     * @return
     */
    @ApiOperation(value = "用户信息接口", notes = "获得用户信息接口")
    @GetMapping("/user_info")
    public Response userInfo() {
        Long userId = getUserId();
        if(userId == null)  {
            return new Response(CommonReturnCode.UNAUTHORIZED.getStatus(), CommonReturnCode.UNAUTHORIZED.getMessage());
        }
        try {
            UserInfoVo userInfo = userInfoMapper.findUserInfoByUserId(userId);
            return new Response(CommonReturnCode.OK, userInfo);
        } catch (BusinessException e) {
            LoggerUtils.error(UserController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @GetMapping("/tenant/function/info")
    @ApiOperation(value = "房客个人中心function信息接口", notes = "获得房客个人中心function信息接口")
    public Response tenantFunction() {
        Long userId = getUserId();
        if(userId == null) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
        try {
            TenantFunction tenantFunction = userService.fundTenantByUserId(userId);
            return new Response(CommonReturnCode.OK, tenantFunction);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @GetMapping("/landlord/function/info")
    @ApiOperation(value = "房东function信息接口", notes = "获得房东个人中心信息接口")
    public Response landlordInfo() {
        Long userId = getUserId();
        if(userId == null) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
        LandlordFunction landlordFunction = null;
        try {
            landlordFunction = userService.findLandlordInfoByUserId(userId);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK, landlordFunction);
    }


    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "更新用户信息", notes = "修改用户信息接口")
    @PostMapping("/userInfo/update")
    public Response updateUserInfo(@RequestBody UserInfo userInfo) {
        //从登陆Token中获得用户编号，并设置到userInfo中
        UserInfo updateUserInfo = null;
        try {
            //执行更新操作
            updateUserInfo = userService.updateUserInfo(userInfo);
            return new Response(CommonReturnCode.OK, updateUserInfo);
        } catch (BusinessException e) {
            LoggerUtils.error(UserController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 更新头像
     * @param avatarPath
     * @return
     */
    @ApiOperation(value = "更新头像", notes = "将上传头像后的URL保存到数据库中")
    @PutMapping("/userInfo/avatar/update")
    public Response updateAvatar(String avatarPath) {
        try {
            Long userId = getUserId();
            if(userId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            userInfoMapper.setAvatar(avatarPath, userId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(UserController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }

    }

    /**
     * 更新昵称
     * @param userName
     * @return
     */
    @ApiOperation(value = "更新昵称", notes = "新增、修改昵称接口")
    @PostMapping("/userInfo/userName/update")
    public Response updateUserName(String userName) {
        //昵称最大长度
        Integer userNameLengthLimit = 12;
        UserInfoVo user = getUserInfo();
        if(null != user.getUserName() && userName.equals(user.getUserName())) {
            LoggerUtils.error(UserController.class, UserReturnCode.USERNAME_SAME.getMessage());
            return new Response(UserReturnCode.USERNAME_SAME);
        }
        if(userName.length() > userNameLengthLimit) {
            LoggerUtils.error(UserController.class, UserReturnCode.USERNAME_LENGTH_LIMIT.getMessage());
            return new Response(UserReturnCode.USERNAME_LENGTH_LIMIT);
        }
        try {
            userService.updateUserName(userName, user.getUserId());
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(UserController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 芝麻信用认证接口
     * @param zhiMaAuth
     * @return
     */
    @ApiOperation(value = "芝麻信用认证", notes = "芝麻信用认证接口")
    @PostMapping("/user/zhiMa/auth")
    public Response zhiMaAuth(@RequestBody ZhiMaAuth zhiMaAuth) {
        try {
            userService.zhiMaAuth(zhiMaAuth);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 实名认证接口
     * @param identityAuth
     * @return
     */
    @PostMapping("/user/identity/auth")
    @ApiOperation(value = "实名认证接口", notes = "实名认证接口")
    public Response identityAuth(@RequestBody IdentityAuth identityAuth) {
        try {
            Long userId = getUserId();
            if(userId == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            identityAuth.setUserId(userId);
            userService.identityAuth(identityAuth);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
