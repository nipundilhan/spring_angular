package com.example.exception1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception1.exception.ApplicationException;
import com.example.exception1.exception.ValidationListException;
import com.example.exception1.request.AddressRequest;
import com.example.exception1.response.ValidateResponse;

@RestController
@RequestMapping(value = "/test2")
public class TestController2 {
	
    @GetMapping("/exception-1")
    ResponseEntity<?> exception1() throws Exception {
        // persisting the user
    	boolean value = true;
    	
    	if(value) {
    		throw new ApplicationException("application exception thorws");
    	}
        return ResponseEntity.ok("ok");
    }
    
    

    @GetMapping("/exception-2")
    ResponseEntity<?> exception2() throws Exception {
        // persisting the user
    	boolean value = true;
        List<ValidateResponse> vldtnLst = new ArrayList<>();
        
        ValidateResponse vr1 = new ValidateResponse("item","record not exists");
        vldtnLst.add(vr1);
        ValidateResponse vr2 = new ValidateResponse("item","status inactive");
        vldtnLst.add(vr2);
        
    	if(!vldtnLst.isEmpty()) {
    		throw new ValidationListException(vldtnLst);
    	}
        return ResponseEntity.ok("ok");
    }

}
