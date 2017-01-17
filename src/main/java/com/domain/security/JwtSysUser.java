package com.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtSysUser extends SysUser implements UserDetails {
    private Collection<? extends GrantedAuthority> sysAuthorities;

    public JwtSysUser(SysUser sysUser) {
        BeanUtils.copyProperties(sysUser, this);
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (sysAuthorities == null) {
            List<SysAuthority> sysAuthorities = this.getSysAuthorities();
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = sysAuthorities.stream()
                    .map(sysAuthority -> new SimpleGrantedAuthority(sysAuthority.getName().getFullName()))
                    .collect(Collectors.toList());
            this.sysAuthorities = simpleGrantedAuthorities;
        }

        return sysAuthorities;
    }

}
