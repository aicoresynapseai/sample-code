package com.genai.devops.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// GenAI generates simple REST controllers based on common patterns or prompts.
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from GenAI-Powered Java App!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}