package com.genai.devops.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// GenAI recognizes the standard entry point for a Spring Boot application.
		SpringApplication.run(Application.class, args);
	}

}