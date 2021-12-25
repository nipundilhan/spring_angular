package com.example.exception1.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exception1.exception.ApplicationException;
import com.example.exception1.exception.CustomHeirachyApplicationException;
import com.example.exception1.exception.ValidationListException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class RootExceptionHandler{

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
		String name = ex.getName();
	    String type = ex.getRequiredType().getSimpleName();
	    Object value = ex.getValue();
	    String message = String.format("'%s' parameter in the request should be of data type '%s' and the value specified '%s' is not of invalid data type",
	                                   name, type, value);
	    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handleApplicationException(ApplicationException ex) {
	    return new ResponseEntity<>(ex.getMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ValidationListException.class)
	public ResponseEntity<?> handleValidationListException(ValidationListException ex) {
	    return new ResponseEntity<>(ex.getValidationList(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(CustomHeirachyApplicationException.class)
	public ResponseEntity<?> handleCustomHeirachyException(CustomHeirachyApplicationException ex) {
	    return new ResponseEntity<>(ex.getCustomResponse(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
