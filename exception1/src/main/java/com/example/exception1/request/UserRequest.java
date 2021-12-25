package com.example.exception1.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class UserRequest {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotNull(message = "addressRequest is mandatory")
	@Valid
	private AddressRequest addressRequest;
	
	@Valid
	//@NotNull(message = "contactList is mandatory")
	private List<ContactRequest> contactList;

	// standard constructors / setters / getters / toString

}
