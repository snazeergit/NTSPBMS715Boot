package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TypeNotFoundException extends Exception {
	public TypeNotFoundException() {
		super();
	}

	public TypeNotFoundException(String msg) {
		super(msg);
	}
}
