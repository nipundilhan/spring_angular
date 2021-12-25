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
public class SubjectResponse {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("parentId")
	private Integer parentId;

	@JsonProperty("name")
	private String name;



}
