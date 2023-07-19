package com.auth.service;

import org.springframework.http.HttpStatus;

import com.auth.model.User;

public interface IAuthService {
	public String validateUser(User uObj);

}


