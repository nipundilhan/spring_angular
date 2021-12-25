package com.example.springangular.response;

import java.util.List;

import com.example.springangular.request.user;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginationFinalResponse {

	@JsonProperty("meta")
	MetaResponse metaResponse;
	
	@JsonProperty("items")
	List<user> userList;
}
