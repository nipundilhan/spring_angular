package com.example.springangular.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springangular.entity.highschool;
import com.example.springangular.entity.student;
import com.example.springangular.repository.highschoolRepository;
import com.example.springangular.repository.studentRepository;
import com.example.springangular.response.SchoolFinalResponseDto;
import com.example.springangular.response.StudentResponseDto;

@RestController // This means that this class is a Controller
@RequestMapping("/test2")
public class TestController2 {
	
	
	@Autowired
	private highschoolRepository schRep;
	
	@Autowired
	private studentRepository stdRep;
	
	@GetMapping("/get-details/school/{id}")
	public SchoolFinalResponseDto getSchollWithStudents(@PathVariable int id) {
		SchoolFinalResponseDto finalResp = new SchoolFinalResponseDto();
		
		Optional<highschool> schoolOptional = schRep.findById(id);
		if(schoolOptional.isPresent()) {
			highschool hghschol = schoolOptional.get();
			
			
			finalResp.setId(hghschol.getId());
			finalResp.setSchoolname(hghschol.getSchoolname());
			finalResp.setYear(hghschol.getYear());
			finalResp.setAddress(hghschol.getAddress());
			
			//List<student> studentList = stdRep.findBySchlId(id);
//			highschool hs = null; 
//			hs = hghschol;
			List<student> studentList = hghschol.getStudents();
			
			List<StudentResponseDto> respList =  new ArrayList<>();
			
			StudentResponseDto principalResp =  new StudentResponseDto();
			principalResp.setFirstname(hghschol.getSchoolname().substring(0,4)+" principal");
			principalResp.setContactvalue("071-4422"+hghschol.getYear());
			
			for(student item : studentList) {
				
				StudentResponseDto resp =  new StudentResponseDto();
				resp.setFirstname(item.getFirstname());
				resp.setLastname(item.getLastname());
				resp.setGrade(item.getGrade());
				resp.setContactvalue(item.getContactvalue());
				
				respList.add(resp);
				
			}
			
			finalResp.setPrinciple(principalResp);
			finalResp.setStudentlist(respList);
					
		}
		
		return finalResp;
		
		
	}
	
	
	@PostMapping("/add-school")
	public String getSchollWithStudents(@RequestBody SchoolFinalResponseDto school) {

		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("     success    ");
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("");
		
		return "sucess";
		
		
	}

}
