package com.domain.security;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_sys_user")
public class SysUser {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Length(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 80)
    @NotNull
    @Length(min = 4, max = 100)
    private String password;

    @Column(name = "FIRST_NAME", length = 50)
    @NotNull
    @Length(min = 4, max = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    @NotNull
    @Length(min = 4, max = 50)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    @Length(min = 4, max = 50)
    @Email
    private String email;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @Column(name = "LAST_PASSWORD_RESET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_sys_user_authority",
            joinColumns = {@JoinColumn(name = "SYS_USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SYS_AUTHORITY_ID", referencedColumnName = "ID")})
    private List<SysAuthority> sysAuthorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<SysAuthority> getSysAuthorities() {
        return sysAuthorities;
    }

    public void setSysAuthorities(List<SysAuthority> sysAuthorities) {
        this.sysAuthorities = sysAuthorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}