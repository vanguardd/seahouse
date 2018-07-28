package com.team.seahouse.repository;

import com.team.seahouse.domain.IdentityAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/26
 */
public interface IdentityAuthRepository extends JpaRepository<IdentityAuth, Long> {
}
