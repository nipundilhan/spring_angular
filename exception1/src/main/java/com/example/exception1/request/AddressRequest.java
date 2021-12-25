package com.example.exception1.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class AddressRequest {
	
	@NotBlank(message = "address1 is mandatory")
	private String address1;
	
	@NotBlank(message = "address2 is mandatory")
	private String address2;

	@NotNull(message = "country request is mandatory")
	@Valid
	CountryRequest countryRequest;
}
