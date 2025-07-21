package com.genai.cicd.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple REST controller for demonstration purposes.
 * GenAI might suggest creating health check endpoints or
 * other default controllers based on common patterns.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from GenAI-powered CI/CD for Java!";
    }
}