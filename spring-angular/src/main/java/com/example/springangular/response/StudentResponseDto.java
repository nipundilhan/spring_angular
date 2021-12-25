package com.example.springangular.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponseDto {

	@JsonProperty("experience")
	private Integer grade;

	@JsonProperty("name")
	private String firstname;

	@JsonProperty("users")
	private String lastname;

	@JsonProperty("email")
	private String contactvalue;

}
