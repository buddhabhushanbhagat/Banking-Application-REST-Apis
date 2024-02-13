package com.bank.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class CustomerCreationFailedException extends RuntimeException {

	public CustomerCreationFailedException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
