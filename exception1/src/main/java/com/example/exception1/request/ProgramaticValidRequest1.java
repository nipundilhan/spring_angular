package com.example.exception1.request;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class ProgramaticValidRequest1 {
	
	private AddressRequest addressRequest;
	

	private List<ContactRequest> contactList;

}
