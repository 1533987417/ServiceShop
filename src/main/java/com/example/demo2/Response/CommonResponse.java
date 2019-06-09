package com.example.demo2.Response;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.UUID;

public class CommonResponse<T> implements Serializable {
    private Integer code;
    private String message;
    private T result;
    private String logId;
    public CommonResponse(){
        this.logId= UUID.randomUUID().toString();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
