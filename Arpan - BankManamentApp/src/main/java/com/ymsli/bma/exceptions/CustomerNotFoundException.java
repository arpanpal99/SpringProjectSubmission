package com.ymsli.bma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="customer not found")
public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
