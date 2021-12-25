package com.example.springangular.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springangular.entity.student;
import com.example.springangular.repository.studentRepository;
import com.example.springangular.request.user;
import com.example.springangular.response.MetaResponse;
import com.example.springangular.response.PaginationFinalResponse;
import com.example.springangular.response.SampleResponse1;
import com.example.springangular.response.SchoolFinalResponseDto;

@RestController // This means that this class is a Controller
@RequestMapping("/test")
public class TestController1 {
	
	@Autowired
	private studentRepository stdRep;
	
	@PostMapping("/save-student")
	public String saveStudent1(@RequestBody student std) {
		
		

		stdRep.save(std);
		
		SampleResponse1 response = new SampleResponse1();
		response.setCode(1);response.setMessage("success");
		
		return "success";
	}
	
	
	@PostMapping("/save-user")
	public user saveStudent2(@RequestBody user usr) {
		
		
		student std = new student();
		std.setFirstname(usr.getName());
		std.setGrade(usr.getExperience());
		std.setContactvalue(usr.getEmail());
		std.setLastname(usr.getDomain());
		stdRep.save(std);
		
		SampleResponse1 response = new SampleResponse1();
		response.setCode(1);response.setMessage("success");
		
		return usr;
	}
	
	@GetMapping("/all-students")
	public List<user>  getAllStudents() {
		List<user> usersList = new ArrayList<>();
		List<student> findAll = stdRep.findAll();
		for(student std :findAll) {
			user usr = new user(std.getFirstname(),std.getContactvalue(),std.getGrade(),std.getLastname());
			usersList.add(usr);
		}
			
		return usersList;
	}
	
	@PostMapping("/search-students")
	public List<user> searchStudents(@RequestBody user usr){
		
		List<user> usersList = new ArrayList<>();
		List<student> findAll = stdRep.findAll();
		System.out.println("method hitted");
		
		if(usr.name != null) {
			System.out.println("filtering 1");
			findAll = findAll.stream().filter(n -> n.getFirstname().startsWith(usr.name)  ).collect(Collectors.toList());
		}		
		if(usr.email != null) {
			System.out.println("filtering 2");
			findAll = findAll.stream().filter(n -> n.getContactvalue().startsWith(usr.email)  ).collect(Collectors.toList());
		}
		
		for(student std :findAll) {
			System.out.println("mapping response");
			user usr1 = new user(std.getFirstname(),std.getContactvalue(),std.getGrade(),std.getLastname());
			usersList.add(usr1);
		}
		return usersList;
	}
	
	
	@GetMapping("/pagination/{number}/{size}")
	public PaginationFinalResponse getUserPagination(@PathVariable int number ,@PathVariable int size) {
		
		List<user> usersList = new ArrayList<>();
		List<student> findAll = stdRep.findAll();
		
		List<student> finalList = null;
		int startpage = 0;
		if(number > 0) {
			startpage = (number-1)*size;
		}
		
		findAll = findAll.stream().sorted(Comparator.comparingLong(student::getId))
                .collect(Collectors.toList());
		finalList = findAll.stream().skip(startpage).limit(size).collect(Collectors.toList());
		
		for(student std :finalList) {
			user usr = new user(std.getFirstname(),std.getContactvalue(),std.getGrade(),std.getLastname());
			usersList.add(usr);
		}
		
		MetaResponse metaResponse = new MetaResponse();
		metaResponse.setTotalItems(findAll.size());
		metaResponse.setPageNumber(number);
		
		metaResponse.setPageSize(size);
		
		
		PaginationFinalResponse response = new PaginationFinalResponse();
		response.setUserList(usersList);
		response.setMetaResponse(metaResponse);
			
		return response;
		
	}

}
