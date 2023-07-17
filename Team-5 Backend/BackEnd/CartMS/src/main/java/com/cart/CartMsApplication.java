package com.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cart.filter.JWTfilter;

@SpringBootApplication
@EnableDiscoveryClient
public class CartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartMsApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFiler()
	{
		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
		filterRegistraionBean.setFilter(new JWTfilter());
//		filterRegistraionBean.addUrlPatterns("/cart/addToCart/**");
//		filterRegistraionBean.addUrlPatterns("/cart/getAllCartItems/**");
//		filterRegistraionBean.addUrlPatterns("/cart/getCartItemById/**");
//		filterRegistraionBean.addUrlPatterns("/cart/delCartById/**");
		filterRegistraionBean.addUrlPatterns("/cart/**");
		return filterRegistraionBean ;
		
	}

}
