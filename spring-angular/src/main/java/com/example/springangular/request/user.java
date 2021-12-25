package com.example.springangular.request;

import com.example.springangular.response.SampleResponse1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class user {
	public String name;
	public String email;
	public int experience;
	public String domain;
}
