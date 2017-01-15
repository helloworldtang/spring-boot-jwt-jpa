package com.domain.response.security;

import java.io.Serializable;

public class JwtAuthenticationRes implements Serializable {

    private final String token;

    public JwtAuthenticationRes(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}