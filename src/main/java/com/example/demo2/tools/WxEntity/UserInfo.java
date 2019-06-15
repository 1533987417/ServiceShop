package com.example.demo2.tools.WxEntity;

public class UserInfo {
    private String encryptedData;
    private String iv;
    private String rawData;
    private String signature;
    private enUserInfo userInfo;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public enUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(enUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
