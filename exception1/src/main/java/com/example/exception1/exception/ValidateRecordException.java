package com.example.exception1.exception;

public class ValidateRecordException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String key;
	String value;
	
	public ValidateRecordException() {
		super();
	}
	
	public ValidateRecordException(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
