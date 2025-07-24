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
 * Service to simulate fetching Git commit messages.
 * In a real-world scenario, this would interact with a Git repository
 * using a library like JGit or by executing shell commands (e.g., `git log`).
 */
@Service
public class GitService {

    // Injecting ResourceLoader to load files from the classpath
    private final ResourceLoader resourceLoader;

    // Path to the simulated commits file, configured in application.properties
    @Value("${simulated.git.commits.file}")
    private String simulatedCommitsFile;

    public GitService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * Simulates fetching Git commit messages for a given range.
     *
     * @param fromRef The starting Git reference (e.g., a tag, commit hash).
     * @param toRef   The ending Git reference (e.g., HEAD, a branch name).
     * @return A list of simulated commit messages.
     * @throws IOException if the simulated file cannot be read.
     */
    public List<String> getCommitMessages(String fromRef, String toRef) throws IOException {
        System.out.println("Simulating fetching commit messages from " + fromRef + " to " + toRef);

        // Load content from the simulated commits file
        Resource resource = resourceLoader.getResource("classpath:" + simulatedCommitsFile);
        if (!resource.exists()) {
            throw new IOException("Simulated Git commits file not found: " + simulatedCommitsFile);
        }

        String fileContent = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

        // Split the content into individual commit messages and trim whitespace
        return Arrays.stream(fileContent.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    // In a real scenario, you might have methods like:
    // public List<String> getCommitMessages(String repositoryPath, String fromRef, String toRef) { ... }
    // which would execute `git log --pretty=format:%s fromRef..toRef`
}