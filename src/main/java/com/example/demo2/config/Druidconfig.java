package com.example.demo2.config;
import com.alibaba.druid.support.http.StatViewServlet;import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Druidconfig {
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("allow","192.168.1.218,127.0.0.1");
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

}
