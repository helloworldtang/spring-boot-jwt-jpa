package com.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Entity
@Table(name = "USER_AUTHORITY")
public class UserAuthority {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "USER_ID")
    private Long userId;

    @NotNull
    @Column(name = "AUTHORITY_ID")
    private Long authorityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }
}
