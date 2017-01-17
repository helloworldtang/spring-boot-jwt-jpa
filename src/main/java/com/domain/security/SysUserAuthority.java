package com.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Entity
@Table(name = "tb_sys_user_authority")
public class SysUserAuthority {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "SYS_USER_ID")
    private Long sysUserId;

    @NotNull
    @Column(name = "SYS_AUTHORITY_ID")
    private Long sysAuthorityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysAuthorityId() {
        return sysAuthorityId;
    }

    public void setSysAuthorityId(Long sysAuthorityId) {
        this.sysAuthorityId = sysAuthorityId;
    }
}
