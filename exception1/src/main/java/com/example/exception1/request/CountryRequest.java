package com.example.exception1.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class CountryRequest {
	
	@Pattern(regexp = "GODAGAMA|HOMAGAMA", message = "city value wrong")
	@Size(max = 10, message = "wrong size")
	@NotBlank(message = "city is mandatory")
	private String city;
	
	@NotBlank(message = "country is mandatory")
	private String country;


}
