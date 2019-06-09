package com.example.demo2.tools;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public WxMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.ALL);
        setSupportedMediaTypes(mediaTypes);// tag6
        setDefaultCharset(Charset.forName("UTF-8"));
    }
}