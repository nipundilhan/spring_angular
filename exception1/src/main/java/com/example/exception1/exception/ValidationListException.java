package com.example.exception1.exception;

import java.util.List;

import com.example.exception1.response.ValidateResponse;

public class ValidationListException extends Exception {
	
	List<ValidateResponse> validationList;

	public ValidationListException() {
		super();
	}
	
	public ValidationListException(List<ValidateResponse> validationList) {
		super();
		this.validationList = validationList;
	}
	
	
	
	public List<ValidateResponse> getValidationList() {
		return validationList;
	}

	public void setValidationList(List<ValidateResponse> validationList) {
		this.validationList = validationList;
	}

	
	

}
