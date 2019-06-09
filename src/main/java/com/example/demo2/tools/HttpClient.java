package com.example.demo2.tools;

import com.example.demo2.tools.WxEntity.CreateOrderRequest;
import com.example.demo2.tools.WxEntity.Result;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;


@Service
public class HttpClient {
    public Result client(String url, HttpMethod method, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<Result> response = client.exchange(url, HttpMethod.POST, requestEntity, Result.class);
        return response.getBody();
    }
    /**  
      * 发送xml数据请求到server端  
      * @param url xml请求数据地址  
      * @param xmlString 发送的xml数据流  
      * @return null发送失败，否则返回响应内容  
      */
         public  String post(String url,String xmlFileName) {

             RestTemplate client = new RestTemplate();
             client.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
             HttpHeaders headers = new HttpHeaders();
             List<Charset> charsetArray = new ArrayList<>();
             charsetArray.add(Charset.forName("gb2312"));
             //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
             headers.setContentType(MediaType.TEXT_XML);
             headers.setAcceptCharset(charsetArray);
             HttpEntity<String> requestEntity = new HttpEntity<String>(xmlFileName, headers);
             //  执行HTTP请求
             ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
             return response.getBody();
         }
    public static void main(String[] args) throws UnsupportedEncodingException {

        HttpClient client=new HttpClient();
        CreateOrderRequest request=new CreateOrderRequest();
        request.setAppid("44444");
      String result=  client.post("https://api.mch.weixin.qq.com/pay/unifiedorder",XMLUtil.convertToXml(request));

        System.out.println(new String( result.getBytes("iso-8859-1"), "utf-8"));
    }
}