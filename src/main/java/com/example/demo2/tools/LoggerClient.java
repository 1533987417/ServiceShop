package com.example.demo2.tools;

import com.example.demo2.config.DruidDBConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class LoggerClient {
    private Logger logger =LoggerFactory.getLogger(LoggerClient.class);
    public  Logger getInstance(){
        return this.logger;
    }
    public void info(){

    }

}
