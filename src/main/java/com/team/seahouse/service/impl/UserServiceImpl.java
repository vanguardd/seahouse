package com.team.seahouse.service.impl;

import com.team.seahouse.commons.utils.JwtTokenUtil;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserInfo findByToken(String tokenStr) {
        final String token = tokenStr.substring(tokenHead.length());
        Long userId = jwtTokenUtil.getUserIdFromToken(token);
        if(userId != null) {
            return userInfoRepository.findByUserId(userId);
        }
        return null;
    }
}
