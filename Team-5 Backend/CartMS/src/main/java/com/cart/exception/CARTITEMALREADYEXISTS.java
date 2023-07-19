package com.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="Cart Item Already Exists")
public class CARTITEMALREADYEXISTS extends Exception {

}
