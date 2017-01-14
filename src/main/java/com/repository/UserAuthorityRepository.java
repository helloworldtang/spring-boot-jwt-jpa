package com.repository;

import com.domain.security.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
}
