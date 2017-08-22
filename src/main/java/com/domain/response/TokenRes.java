package com.domain.response;

public class TokenRes {
    private String token;

    public TokenRes() {
    }

    public TokenRes(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
