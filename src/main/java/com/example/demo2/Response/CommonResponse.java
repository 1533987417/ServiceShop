package com.example.demo2.Response;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.UUID;

public class CommonResponse<T> implements Serializable {
    private Integer errno;
    private String errmsg;
    private T data;
    private String logId;
    public CommonResponse(){
        this.logId= UUID.randomUUID().toString();
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
