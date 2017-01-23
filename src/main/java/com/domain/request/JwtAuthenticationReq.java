package com.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class JwtAuthenticationReq implements Serializable {
    @ApiModelProperty(required = true, example = "admin")
    private String username;

    @ApiModelProperty(required = true)
    private String password;

    public JwtAuthenticationReq() {
        super();
    }

    public JwtAuthenticationReq(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
