package com.bank.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class BankCustomerAlredyExistsException extends RuntimeException {

	public BankCustomerAlredyExistsException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
