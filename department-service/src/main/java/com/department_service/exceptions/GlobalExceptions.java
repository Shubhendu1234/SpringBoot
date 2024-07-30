package com.department_service.exceptions;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSunchElementException(NoSuchElementException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> handleIllegalArgumentException(IllegalArgumentException exception,WebRequest request)
	{
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false),"404"),HttpStatus.NOT_FOUND);
	}
	

}
