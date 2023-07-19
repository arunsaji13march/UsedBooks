package com.project.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.project.order.filter.JWTFilter;

@SpringBootApplication
public class OrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFiler()
	{
		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
		filterRegistraionBean.setFilter(new JWTFilter());
//		filterRegistraionBean.addUrlPatterns("/orders/api/getAllOrder/**");
//		filterRegistraionBean.addUrlPatterns("/orders/api/editOrderStatus/**");
//		filterRegistraionBean.addUrlPatterns("/orders/api/getOrderById/**");
//		filterRegistraionBean.addUrlPatterns("/orders/api/getOrderByOrderId/**");
		filterRegistraionBean.addUrlPatterns("/orders/api/**");
		return filterRegistraionBean ;
		
	}






}
