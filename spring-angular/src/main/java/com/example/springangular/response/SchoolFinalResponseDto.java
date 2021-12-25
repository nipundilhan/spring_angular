package com.example.springangular.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SchoolFinalResponseDto {
	
	private Integer id;

	private String schoolname;
	
	private String address;
	
	private Integer year;
	
	@JsonProperty("principal")
	StudentResponseDto principle;
	
	@JsonProperty("users")
	List<StudentResponseDto> studentlist;

}
