package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.seahouse.commons.enums.StatusEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/12
 */
public class JwtUser implements UserDetails {

    private final Long userId;
    private final String userName;
    private final String password;
    private Date lastPasswordResetDate;
    private Integer state;

    public JwtUser(Long id, String userName, String password, Date lastPasswordResetDate, Integer state) {
        this.userId = id;
        this.userName = userName;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.state = state;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    public Long getId() {
        return userId;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return userName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        if(state.equals(StatusEnum.FREEZE)) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
