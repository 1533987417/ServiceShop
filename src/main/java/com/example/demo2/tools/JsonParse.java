package com.example.demo2.tools;

import com.google.gson.Gson;

/**
 * 单例构造序列方法
 */
public class JsonParse {
    private static Gson gson=new Gson();
    public static Gson getInstance(){
        return gson;
    }
}
