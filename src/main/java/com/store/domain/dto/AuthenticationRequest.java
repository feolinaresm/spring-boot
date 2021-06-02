package com.store.domain.dto;

public class AuthenticationRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPass(String password) {
        this.password = password;
    }
}
