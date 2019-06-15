package com.example.demo2.Response;

import com.example.demo2.entity.User;
import com.example.demo2.tools.WxEntity.enUserInfo;

public class UserInfoResponse {
    private String token;
    private User userInfo;

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;

    }

    public void setToken(String token) {
        this.token = token;
    }

}
