package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // GenAI recognizes this as a Spring Boot application
@RestController // GenAI would suggest a simple endpoint for testing reachability
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/") // A basic endpoint for health checks or initial testing
	public String home() {
		return "Hello from AI-Generated CI/CD Java App!";
	}
}