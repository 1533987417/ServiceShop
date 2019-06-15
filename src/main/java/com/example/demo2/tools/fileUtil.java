package com.example.demo2.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import static java.net.URLDecoder.decode;

public class fileUtil {


    static String url="http://localhost:8081/ykt/";

    public static String GenerateImage(String imgStr)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return "";
       String[] arry= imgStr.split(",");
      String frex= arry[0].split(";")[0].split("/")[1];
      String imgStrByt=arry[1];
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStrByt);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            String imageFile=UUID.randomUUID().toString()+"."+frex;
            //生成jpeg图片
            String imgFilePath = decode(ResourceUtils.getURL("classpath:static/ykt/").getPath(),"utf-8").substring(1)   ;//新生成的图片
            FileOutputStream out = new FileOutputStream(imgFilePath+imageFile);
            out.write(b);
            out.flush();
            out.close();
            return url+imageFile;
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
}
