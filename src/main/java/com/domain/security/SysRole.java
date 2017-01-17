package com.domain.security;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public enum SysRole {
    ROLE_ADMIN(1L, "ADMIN", "ROLE_ADMIN"),
    ROLE_USER(2L, "USER", "ROLE_USER");

    private Long id;
    private String shortName;
    private String fullName;

    SysRole(Long id, String shortName, String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }
}
