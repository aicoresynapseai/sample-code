package com.genai.releasenotes.generator;

import com.genai.releasenotes.generator.model.ReleaseNote;
import com.genai.releasenotes.generator.service.DeploymentLogService;
import com.genai.releasenotes.generator.service.GenAIService;
import com.genai.releasenotes.generator.service.GitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Main application class for the GenAI-powered Release Notes Generator.
 * This class orchestrates the process of fetching data, sending it to GenAI,
 * and displaying the generated release notes.
 *
 * It implements CommandLineRunner to execute logic right after Spring Boot application start-up.
 */
@SpringBootApplication
public class GenAIRelaseNotesGeneratorApplication implements CommandLineRunner {

    // Injecting services using Spring's dependency injection
    private final GitService gitService;
    private final DeploymentLogService deploymentLogService;
    private final GenAIService genAIService;

    /**
     * Constructor for dependency injection.
     * @param gitService Service to fetch Git commit messages.
     * @param deploymentLogService Service to fetch deployment logs.
     * @param genAIService Service to interact with the Generative AI API.
     */
    public GenAIRelaseNotesGeneratorApplication(GitService gitService,
                                                DeploymentLogService deploymentLogService,
                                                GenAIService genAIService) {
        this.gitService = gitService;
        this.deploymentLogService = deploymentLogService;
        this.genAIService = genAIService;
    }

    /**
     * Main method to start the Spring Boot application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(GenAIRelaseNotesGeneratorApplication.class, args);
    }

    /**
     * Callback method called after the application context is loaded.
     * This is where the main logic for generating release notes resides.
     * @param args Command line arguments.
     * @throws Exception if an error occurs during execution.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Starting GenAI-Powered Release Notes Generation...");

        // 1. Simulate fetching Git commit messages for the current release.
        // In a real scenario, you'd specify a commit range (e.g., from last tag to HEAD).
        List<String> commitMessages = gitService.getCommitMessages("v1.0.0", "HEAD");
        System.out.println("\n--- Fetched Git Commit Messages ---");
        commitMessages.forEach(System.out::println);

        // 2. Simulate fetching deployment logs for the current deployment.
        // In a real scenario, this would come from a CI/CD tool's API or log aggregator.
        List<String> deploymentLogs = deploymentLogService.getDeploymentLogs("build-1234");
        System.out.println("\n--- Fetched Deployment Logs ---");
        deploymentLogs.forEach(System.out::println);

        // 3. Generate release notes using the GenAI service.
        System.out.println("\n--- Calling GenAI Service to Generate Release Notes ---");
        ReleaseNote releaseNote = genAIService.generateReleaseNotes(commitMessages, deploymentLogs);

        // 4. Display the generated release notes.
        System.out.println("\n=======================================================");
        System.out.println("          ✨ AUTO-GENERATED RELEASE NOTES ✨          ");
        System.out.println("=======================================================");
        System.out.println("Version: " + releaseNote.getVersion());
        System.out.println("Date: " + releaseNote.getReleaseDate());
        System.out.println("\n" + releaseNote.getContent());
        System.out.println("=======================================================");
        System.out.println("📝 Release notes generated successfully!");
        System.out.println("--- End of process ---");

        // In a real CI/CD pipeline, you would now publish `releaseNote`
        // to a wiki, send an email, or update a documentation system.
    }
}