package com.example.demo2.Request;

import com.example.demo2.tools.WxEntity.UserInfo;

public class WeiXinRequest {
    private  String code;
    private UserInfo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
