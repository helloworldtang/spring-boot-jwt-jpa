package com.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_sys_authority")
public class SysAuthority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private SysRole name;

    @ManyToMany(mappedBy = "sysAuthorities", fetch = FetchType.LAZY)//对应SysUser中的字段名sysAuthorities
    private List<SysUser> sysUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysRole getName() {
        return name;
    }

    public void setName(SysRole name) {
        this.name = name;
    }

    public List<SysUser> getUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}