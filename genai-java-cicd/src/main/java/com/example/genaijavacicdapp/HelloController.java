package com.example.genaijavacicdapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// GenAI detects a REST controller, indicating a web application
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from GenAI-powered CI/CD!"; // A simple endpoint for testing deployment
    }
}