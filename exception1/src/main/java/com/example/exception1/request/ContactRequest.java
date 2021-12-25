package com.example.exception1.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class ContactRequest {
	
	@NotBlank(message = "type is mandatory")
	@Size(max = 6, message = "wrong size")
	@Pattern(regexp = "MOBILE|EMAIL", message = " value should be mobile or email")
	private String type;

	@NotBlank(message = "value is mandatory")
	@Size(max = 20, message = "wrong size")
	private String value;

}
