package com.example.exception1.exception;

import com.example.exception1.response.CustomHeirachyResponse;

public class CustomHeirachyApplicationException  extends Exception {

	CustomHeirachyResponse<?> customResponse;

	public CustomHeirachyApplicationException(CustomHeirachyResponse<?> customResponse) {
		super();
		this.customResponse = customResponse;
	}

	public CustomHeirachyResponse<?> getCustomResponse() {
		return customResponse;
	}

	public void setCustomResponse(CustomHeirachyResponse<?> customResponse) {
		this.customResponse = customResponse;
	}
	
	



	
	

}
