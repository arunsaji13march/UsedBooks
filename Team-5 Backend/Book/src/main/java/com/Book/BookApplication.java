package com.Book;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.Book.filter.JWTfilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFiler()
	{
		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
		filterRegistraionBean.setFilter(new JWTfilter());
//		filterRegistraionBean.addUrlPatterns("/books/v1/getAllBooks");
		filterRegistraionBean.addUrlPatterns("/books/v1/addBook/**");
		filterRegistraionBean.addUrlPatterns("/books/v1/deleteBooks/**");
		filterRegistraionBean.addUrlPatterns("/books/v1/updateBook/**");
		filterRegistraionBean.addUrlPatterns("/books/v1/getBooksById/**");
		filterRegistraionBean.addUrlPatterns("/books/v1/user/**");
		return filterRegistraionBean ;
		
	}


}
