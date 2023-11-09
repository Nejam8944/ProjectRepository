package com.cg.trg.boot.controllers;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.trg.boot.dto.AppResponse;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;
import com.cg.trg.boot.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class AppErrorHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	String message =	ex.getBindingResult()
		.getFieldErrors()
		.stream()
		.map(f->f.getDefaultMessage())
		.collect(Collectors.joining(","));
		
		AppResponse resp = new AppResponse("INVALID", message);
		return new ResponseEntity<Object>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<AppResponse> handleEmployeeNotFound(EmployeeNotFoundException ex) {
		return new ResponseEntity<AppResponse>(ex.getResponse(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	public ResponseEntity<AppResponse> handleDuplicateNotFound(DuplicateEmployeeException ex) {
		return new ResponseEntity<AppResponse>(ex.getResponse(), HttpStatus.BAD_REQUEST);
	}
	
}
