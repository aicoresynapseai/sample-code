package com.example.devops.copilot.demo.service;

import org.springframework.stereotype.Service;

// Copilot can suggest service class boilerplate
// Try typing `// Service class for user management`
@Service
public class UserService {

    // Dummy user repository for demonstration
    // Copilot can suggest creating an interface or a simple class
    private final UserRepository userRepository = new UserRepository();

    public boolean registerUser(String username, String password) {
        // Copilot can suggest basic validation logic
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        // Assume user registration logic here
        // Copilot might suggest adding a user to a list or database
        return userRepository.saveUser(username, password);
    }

    public boolean loginUser(String username, String password) {
        // Copilot can suggest authentication logic
        return userRepository.findUser(username, password);
    }

    // Dummy UserRepository class
    // Copilot can help define simple data operations
    private static class UserRepository {
        public boolean saveUser(String username, String password) {
            // In a real app, this would save to a DB
            System.out.println("Saving user: " + username);
            return true;
        }

        public boolean findUser(String username, String password) {
            // In a real app, this would query a DB
            System.out.println("Finding user: " + username);
            return username.equals("testuser") && password.equals("password");
        }
    }
}