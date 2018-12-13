package com.springcloud.zuul.user;

import java.util.List;

public class CustomUserDetails {

    /**
     * 用户名
     */
    private String username;
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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }


}
