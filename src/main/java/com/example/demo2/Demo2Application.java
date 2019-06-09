package com.example.demo2;

import com.alibaba.druid.support.http.WebStatFilter;
import com.example.demo2.tools.JwtAuthenticationFilter;
import org.apache.catalina.filters.WebdavFixFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication
public class Demo2Application {
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebdavFixFilter());
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
		//registrationBean.addUrlPatterns("/*");
		//registrationBean.addInitParameter("exclusions","/druid/*,/hello");
		registrationBean.setFilter(filter);

		return registrationBean;
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}
