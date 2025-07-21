package com.genai.cicd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main Spring Boot application class.
 * GenAI would recognize this class and the Spring Boot annotations
 * to understand the application type and entry point.
 */
@SpringBootApplication
public class GenaiCicdDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenaiCicdDemoApplication.class, args);
    }

}