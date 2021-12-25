package com.example.springangular.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MetaResponse {
	
	int totalItems;
	int pageNumber;
	int pageSize;

}
