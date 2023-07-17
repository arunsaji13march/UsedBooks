package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.api.filter.JWTFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMsApplication.class, args);
	}
	
	
	
	

}
