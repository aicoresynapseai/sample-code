package com.example.devops.copilot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Copilot can help generate the basic Spring Boot application structure
// Try typing `// Main Spring Boot application class`
@SpringBootApplication
@RestController
public class JavaDevOpsCopilotDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDevOpsCopilotDemoApplication.class, args);
	}

	// Copilot can suggest common REST endpoints
	// Try typing `// Create a simple health check endpoint`
	@GetMapping("/health")
	public String healthCheck() {
		return "Application is up and running!";
	}

	// Copilot can also help with more specific endpoints
	// Try typing `// Endpoint to get a greeting message`
	@GetMapping("/")
	public String home() {
		return "Welcome to Java DevOps Copilot Demo!";
	}

}