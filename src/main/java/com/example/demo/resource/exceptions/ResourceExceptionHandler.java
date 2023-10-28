package com.example.demo.resource.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	private StandardError standardError;
	
	@ExceptionHandler
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException) {
		standardError.setTimestamp(LocalDateTime.now());
		standardError.setStatus(HttpStatus.NOT_FOUND.toString());
		standardError.setMessage("Resource Not Found");
		standardError.setError(resourceNotFoundException.getMessage());
		standardError.setPath("/your/request/path");
	
		return new ResponseEntity<StandardError>(standardError, HttpStatus.NOT_FOUND);
	}
}
