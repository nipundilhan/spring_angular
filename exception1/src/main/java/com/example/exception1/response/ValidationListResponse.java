package com.example.exception1.response;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ValidationListResponse {
	
	String key;
	Map<String, String> errorsList;

}
