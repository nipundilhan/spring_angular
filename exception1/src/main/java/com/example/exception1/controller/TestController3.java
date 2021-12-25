package com.example.exception1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception1.exception.ApplicationException;
import com.example.exception1.exception.CustomHeirachyApplicationException;
import com.example.exception1.request.AddressRequest;
import com.example.exception1.request.ContactRequest;
import com.example.exception1.request.ProgramaticValidRequest1;
import com.example.exception1.request.UserRequest;
import com.example.exception1.response.CustomHeirachyResponse;
import com.example.exception1.response.ValidationListResponse;

@RestController
@RequestMapping(value = "/test3")
public class TestController3 {
	
	@Autowired
	private Environment env;
	
	@Autowired
	Validator validator;
	
    @PostMapping("/programatic-1")
    ResponseEntity<?> exception1(@RequestBody ProgramaticValidRequest1 programaticValidRequest1) {
    	Set<ConstraintViolation<AddressRequest>> validateAddressRequestViolations = validator.validate(programaticValidRequest1.getAddressRequest());
    	Map<String, String> errors = new HashMap<>(); 
    	
    	if(!validateAddressRequestViolations.isEmpty()) {
    		List<ConstraintViolation<AddressRequest>> violationList = validateAddressRequestViolations.stream().collect(Collectors.toList());
    	
    		for(ConstraintViolation<AddressRequest> constrainViolation :violationList) {
    			errors.put(constrainViolation.getPropertyPath().toString(), constrainViolation.getMessage());
    		}
    	}
    	return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    
    @PostMapping("/programatic-2")
    ResponseEntity<?> exception2(@RequestBody ProgramaticValidRequest1 programaticValidRequest1) throws Exception{
    	
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator vldtr = factory.getValidator();
		
		List<ContactRequest> contactList = programaticValidRequest1.getContactList();
		
		int i = 0;
		
		List<ValidationListResponse> errsLst = new ArrayList<>();
		
		if((contactList != null) && (!contactList.isEmpty())) {
			
			
			
			for(ContactRequest request :contactList) {
				Set<ConstraintViolation<ContactRequest>> validateAddressRequestViolations = vldtr.validate(request);
				
				ValidationListResponse response = new ValidationListResponse();
				
		    	if(!validateAddressRequestViolations.isEmpty()) {
		    		List<ConstraintViolation<ContactRequest>> violationList = validateAddressRequestViolations.stream().collect(Collectors.toList());
		    		Map<String, String> errors = new HashMap<>(); 
		    		
		    		for(ConstraintViolation<ContactRequest> constrainViolation :violationList) {
		    			errors.put(constrainViolation.getPropertyPath().toString(), constrainViolation.getMessage());
		    		}
		    		response.setKey("contact List["+i+"]");
		    		response.setErrorsList(errors);
		    	}
		    	errsLst.add(response);
		    	
		    	i = i+1;
				
				
			}
		}
		
		CustomHeirachyResponse<List<ValidationListResponse>> customHeirachyResponse = new CustomHeirachyResponse<>(errsLst);
		boolean valid = true;
		
		if(valid) {
			throw new CustomHeirachyApplicationException(customHeirachyResponse);
		}

		 return ResponseEntity.ok("ok");
    }

}
