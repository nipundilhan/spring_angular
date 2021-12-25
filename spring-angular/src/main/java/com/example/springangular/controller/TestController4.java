package com.example.springangular.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springangular.response.SubjectResponse;

@RestController // This means that this class is a Controller
@RequestMapping("/test4")
public class TestController4 {
	
	@GetMapping("/main-subjects")
	public List<SubjectResponse> mainSub() {
		
		return this.getMainSubjectsList();
		
	}
	
	@GetMapping("/sub-subjects/{id}")
	public List<SubjectResponse> subSubject(@PathVariable int id) {
		
		List<SubjectResponse> subjectsList = getSubjectsList();
		subjectsList = subjectsList.stream().filter(n -> n.getParentId() == id  ).collect(Collectors.toList());
		
		return subjectsList;
		
	}
	
	@PostMapping("/dummy")
	public List<SubjectResponse> dummy(@RequestBody  SubjectResponse req) {
		
		List<SubjectResponse> subjectsList = getSubjectsList();
		return subjectsList;
		
	}
	
	@PostMapping("/dummy2")
	public String dummy2() {
		return "this is ultra max pro dummy";
		
	}
	
	
	public List<SubjectResponse> getSubjectsList() {
		
		List<SubjectResponse> mainSubjectsList = new ArrayList<>();
		SubjectResponse sr1 = new SubjectResponse(1,1,"maths");
		SubjectResponse sr2 = new SubjectResponse(2,1,"physics");
		SubjectResponse sr3 = new SubjectResponse(3,1,"chemistry");
		SubjectResponse sr4 = new SubjectResponse(4,1,"bio");
		SubjectResponse sr5 = new SubjectResponse(5,2,"econ");
		SubjectResponse sr6 = new SubjectResponse(6,2,"accounting");
		SubjectResponse sr7 = new SubjectResponse(7,3,"english lit");
		SubjectResponse sr8 = new SubjectResponse(8,3,"sinhala lit");
		SubjectResponse sr9 = new SubjectResponse(9,3,"history");
		SubjectResponse sr10 = new SubjectResponse(10,3,"drama");
		SubjectResponse sr11 = new SubjectResponse(11,4,"science for tech");
		
		mainSubjectsList.add(sr1);
		mainSubjectsList.add(sr2);
		mainSubjectsList.add(sr3);
		mainSubjectsList.add(sr4);
		mainSubjectsList.add(sr5);
		mainSubjectsList.add(sr6);
		mainSubjectsList.add(sr7);
		mainSubjectsList.add(sr8);
		mainSubjectsList.add(sr9);
		mainSubjectsList.add(sr10);
		mainSubjectsList.add(sr11);
		
		return mainSubjectsList;

	}
	
	
	public List<SubjectResponse> getMainSubjectsList() {
		
		List<SubjectResponse> mainSubjectsList = new ArrayList<>();
		SubjectResponse sr1 = new SubjectResponse(1,null,"sceince");
		SubjectResponse sr2 = new SubjectResponse(2,null,"commerce");
		SubjectResponse sr3 = new SubjectResponse(3,null,"art");
		SubjectResponse sr4 = new SubjectResponse(3,null,"tech");
		mainSubjectsList.add(sr1);
		mainSubjectsList.add(sr2);
		mainSubjectsList.add(sr3);
		mainSubjectsList.add(sr4);
		
		return mainSubjectsList;

	}


}
