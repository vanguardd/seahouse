package com.team.seahouse.commons.security;

import com.team.seahouse.commons.response.UserReturnCode;
import com.team.seahouse.commons.auth.JwtUserFactory;
import com.team.seahouse.domain.User;
import com.team.seahouse.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/12
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        //根据手机号去查询用户信息
        User user = userMapper.findByMobilePhone(loginName);
        if(user == null) {
            //根据邮箱查询用户信息
            user = userMapper.findByEmail(loginName);
            if(user == null) {
                throw new UsernameNotFoundException(UserReturnCode.USER_NOT_EXIST.getMessage());
            } else {
                return JwtUserFactory.create(user);
            }
        } else {
            return JwtUserFactory.create(user);
        }

    }
}
