package com.Jspiders.Employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalEmployeeExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity idExceptionHandler(IdNotFoundException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
}
