package com.example.schedulespring.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.schedulespring.entity.highschool;
import com.example.schedulespring.repository.highschoolRespository;

@Service
public class HighSchoolService {
	
	@Autowired
	private highschoolRespository highSchoolRepo;
	
	
	@Scheduled(fixedRate = 5000)	// 5 seconds
	public String addSchool() {
		highschool hs= new highschool();
		hs.setSchoolname("name"+ new Random().nextInt(1000));		
		highSchoolRepo.save(hs);
		System.out.println("add service executed time - "+ new Date().toString());
		return null;
	}
	
	@Scheduled(cron ="0/15 * * * * *")
	public String getNumberOfSchools() {
		
		String ret = "number of records - "+ highSchoolRepo.count();
		System.out.println(ret);
		return null;
			
	}

}
