package com.genai.releasenotes.generator.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to simulate fetching deployment logs.
 * In a real CI/CD pipeline, this would connect to a CI/CD platform's API
 * (e.g., Jenkins, GitLab CI, GitHub Actions) or a log aggregation service (e.g., Splunk, ELK Stack)
 * to retrieve logs relevant to a specific build or deployment.
 */
@Service
public class DeploymentLogService {

    // Injecting ResourceLoader to load files from the classpath
    private final ResourceLoader resourceLoader;

    // Path to the simulated deployment log file, configured in application.properties
    @Value("${simulated.deployment.log.file}")
    private String simulatedDeploymentLogFile;

    public DeploymentLogService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * Simulates fetching deployment logs for a given build ID.
     *
     * @param buildId The ID of the build or deployment to fetch logs for.
     * @return A list of simulated log lines.
     * @throws IOException if the simulated file cannot be read.
     */
    public List<String> getDeploymentLogs(String buildId) throws IOException {
        System.out.println("Simulating fetching deployment logs for build: " + buildId);

        // Load content from the simulated deployment log file
        Resource resource = resourceLoader.getResource("classpath:" + simulatedDeploymentLogFile);
        if (!resource.exists()) {
            throw new IOException("Simulated deployment log file not found: " + simulatedDeploymentLogFile);
        }

        String fileContent = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

        // Split the content into individual log lines and trim whitespace
        return Arrays.stream(fileContent.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    // In a real scenario, you might have methods like:
    // public List<String> getJenkinsBuildLogs(String jobName, int buildNumber) { ... }
    // public List<String> getGitLabPipelineJobLogs(long projectId, long jobId) { ... }
}