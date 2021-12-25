package com.javatechie.spring.kafka.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "javatechie";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		try {
		List<String> info = new ArrayList<>();
		info.add("NZ - 10/0 - 2.1");
		info.add("NZ - 21/0 - 4.4");
		info.add("NZ - 41/0 - 7.1");
		info.add("NZ - 48/0 - 8.2");
		info.add("NZ - 70/0 - 10.0");
		info.add("NZ - 88/0 - 12.1");
		info.add("NZ - 102/0 - 16.4");
		info.add("NZ - 124/0 - 18.1");
				
//		for(String i : info) {
//			template.send(topic, i);
//		  	Thread t = Thread.currentThread();
//		  	System.out.println("producer published ");
//			try { Thread.sleep(4000); } catch (Exception e) {}
//		}
		
		template.send(topic, name);
		} catch (Exception e) {}
		
		return "Data published";
	}

	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(2532, "User88", new String[] { "Bangalore", "BTM", "house 90" });
		template.send(topic, user);
		return "Json Data published";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}
}
