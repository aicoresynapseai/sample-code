package com.genaitestingforjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Main Spring Boot application class.
// For this example, it primarily serves as a container for our service logic,
// which is the target for AI-driven test generation.
@SpringBootApplication
public class GenAITestingForJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenAITestingForJavaApplication.class, args);
		// In a real application, you might have REST controllers or other components
		// that use CalculatorService. For this demo, the service stands alone.
		System.out.println("GenAITestingForJavaApplication started. " +
				"Check src/main/java/com/genaitestingforjava/service/CalculatorService.java " +
				"and its tests in src/test/java/com/genaitestingforjava/service/CalculatorServiceTest.java");
	}

}