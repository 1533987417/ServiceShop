package com.example.demo2.tools;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggerClient {
    private Logger logger = Logger.getLogger(LoggerClient.class);


    public void info(String message,String filder1,String filder2){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(message);
        stringBuffer.append("|");
        stringBuffer.append(filder1);
        stringBuffer.append("|");
        stringBuffer.append(filder2);
        logger.info(stringBuffer.toString());
    }

    public void warn(String message,String filder1,String filder2){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(message);
        stringBuffer.append("|");
        stringBuffer.append(filder1);
        stringBuffer.append("|");
        stringBuffer.append(filder2);
        logger.warn(stringBuffer.toString());
    }

    public void error(String message,Throwable ex,String filder1,String filder2){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(message);
        stringBuffer.append("|");
        stringBuffer.append(filder1);
        stringBuffer.append("|");
        stringBuffer.append(filder2);
        logger.error(stringBuffer.toString(),ex);
    }
    public void error(String message,String filder1,String filder2){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(message);
        stringBuffer.append("|");
        stringBuffer.append(filder1);
        stringBuffer.append("|");
        stringBuffer.append(filder2);
        logger.error(stringBuffer.toString());
    }
}
