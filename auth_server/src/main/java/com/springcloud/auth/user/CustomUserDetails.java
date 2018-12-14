package com.springcloud.auth.user;

import java.util.List;

public class CustomUserDetails {

    /**
     * 用户名
     */
    private String username;

    private String password;
    /**
     * 权限代码列表
     */
    private List<String> authorities;

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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }


}
