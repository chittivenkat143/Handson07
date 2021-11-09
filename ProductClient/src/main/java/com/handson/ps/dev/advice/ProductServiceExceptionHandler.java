package com.handson.ps.dev.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.handson.ps.dev.exception.ApiError;
import com.handson.ps.dev.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductServiceExceptionHandler {
	
	@ExceptionHandler({ ProductNotFoundException.class })
	public ResponseEntity<Object> handleAll() {
	    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Product Not Found", "error occurred");
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
