package com.example.schedulespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduleSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleSpringApplication.class, args);
	}

}
