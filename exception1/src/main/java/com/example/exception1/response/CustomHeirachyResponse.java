package com.example.exception1.response;



public class CustomHeirachyResponse<T>{

	private T data;
	
	public CustomHeirachyResponse() {
		super();
	}
	
	public CustomHeirachyResponse(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
