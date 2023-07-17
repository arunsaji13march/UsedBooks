package com.auth.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.model.User;

@FeignClient(name="register-service", url="http://localhost:8080/users/v1")
public interface RegisterRestConsumer {
	
	@GetMapping("/getuserbyuserEmail/{userEmail}")
	public User getuserByUserEmailHandler(@PathVariable String userEmail);
	
	

}
