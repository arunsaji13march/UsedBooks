package com.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.filter.JWTFilter;

@Configuration
public class GatewayRoutingConfig {
	
	@Bean
	public RouteLocator configRoute(RouteLocatorBuilder builder) {
		return builder.routes()
						.route("Register",r -> r.path("/users/v1/**").uri("http://localhost:8080"))
						.route("Auth",r -> r.path("/path/**").uri("http://localhost:8084"))
						.route("Book", r -> r.path("/books/v1/**").uri("http://localhost:8085"))
						.route("Cart",r -> r.path("/cart/**").uri("http://localhost:8082"))
						.route("Order", r -> r.path("/orders/api/**").uri("http://localhost:8083"))
						.build();
	}
//	@Bean
//	public FilterRegistrationBean jwtFiler()
//	{
//		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
//		filterRegistraionBean.setFilter(new JWTFilter());
//		filterRegistraionBean.addUrlPatterns("http://localhost:8080/users/v1/getAllUsers");
//		filterRegistraionBean.addUrlPatterns("http://localhost:8089/users/v1/updateuser/*");
//		filterRegistraionBean.addUrlPatterns("http://localhost:8089/users/v1/getuserbyid/*");
//		filterRegistraionBean.addUrlPatterns("http://localhost:8089/users/v1/deleteUser/*");
//		return filterRegistraionBean ;
//		
//	}
	

}
