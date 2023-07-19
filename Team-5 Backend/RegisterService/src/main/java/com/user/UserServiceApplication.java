package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.user.filter.JWTFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFiler()
	{
		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
		filterRegistraionBean.setFilter(new JWTFilter());
		filterRegistraionBean.addUrlPatterns("/users/v1/getAllUsers/**");
		filterRegistraionBean.addUrlPatterns("/users/v1/updateuser/**");
		filterRegistraionBean.addUrlPatterns("/users/v1/getuserbyid/**");
		filterRegistraionBean.addUrlPatterns("/users/v1/deleteUser/**");
		return filterRegistraionBean ;
		
	}

}
