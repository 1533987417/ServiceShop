package com.example.demo2.Response;

public enum ResponseEnum {
    RESPONSE_ENUM_Parm_Error(201,"参数错误"),
    RESPONSE_ENUM_Miss_Token(401,"请重新登陆"),
    RESPONSE_ENUM_Exception(500,"服务异常"),
    RESPONSE_ENUM_Success(200,"请求成功");
    ResponseEnum(int code,String desc){
        this.code=code;
        this.desc=desc;
    }
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
