package com.domain.security;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
