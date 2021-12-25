package com.example.exception1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception1.request.AddressRequest;
import com.example.exception1.request.UserRequest;

@RestController
@RequestMapping(value = "/test1")
public class TestController1 {
	
	@Autowired
	private Environment env;
	
	@Value( "${comman.save-success}" )
	private String msg1;

    @PostMapping("/user")
    ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {
        // persisting the user
        return ResponseEntity.ok(msg1);
    }
    
    @PostMapping("/address")
    ResponseEntity<?> addAddress(@Valid @RequestBody AddressRequest addressRequest) {
        // persisting the user
        return ResponseEntity.ok(env.getProperty("comman.request-ok"));
    }
    
    @GetMapping("/irr/{guesss}")
    ResponseEntity<?> irr(@PathVariable(value = "guesss") double guess) {
        // persisting the user
    	
    	double a[] = {32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84,
    			32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84,
    			32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84,
    			32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84,
    			32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84,
    			32601.84,32601.84,32601.84,32601.84,  32601.84,32601.84,32601.84,32601.84,    32601.84,32601.84,32601.84,32601.84
    	
    					};
    	
//    	double a[] = {100.00,100.00,100.00,100.00,100.00,	100.00,100.00,100.00,100.00,100.00};
    	
    	 double irr = org.apache.poi.ss.formula.functions.Irr.irr(a, guess);
    	 System.out.println("irr - " +irr + " guess " +guess);
    	
        return ResponseEntity.ok(irr);
    }
}
