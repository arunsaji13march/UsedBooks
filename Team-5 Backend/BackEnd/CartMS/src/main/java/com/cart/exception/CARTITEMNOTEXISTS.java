package com.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason="Cart Item Not Found")
public class CARTITEMNOTEXISTS extends Exception {

}
