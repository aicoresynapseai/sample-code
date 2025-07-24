package com.genai.releasenotes.generator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genai.releasenotes.generator.model.ReleaseNote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Service to interact with a Generative AI API for release notes generation.
 * This class provides a conceptual implementation, demonstrating prompt construction
 * and a mock API call. In a real application, you would replace the `callGenAIApi`
 * method with actual HTTP requests to your chosen GenAI provider (e.g., OpenAI, Anthropic, Google Gemini).
 */
@Service
public class GenAIService {

    // Placeholder for GenAI API URL and Key from application.properties
    @Value("${genai.api.url}")
    private String genAIApiUrl;
    @Value("${genai.api.key}")
    private String genAIApiKey;
    @Value("${genai.api.model}")
    private String genAIApiModel;

    // ObjectMapper for JSON serialization/deserialization (useful for real API calls)
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Generates release notes by sending commit messages and deployment logs to a GenAI API.
     *
     * @param commitMessages   A list of Git commit messages for the current release.
     * @param deploymentLogs   A list of relevant deployment log entries.
     * @return A ReleaseNote object containing the auto-generated content.
     */
    public ReleaseNote generateReleaseNotes(List<String> commitMessages, List<String> deploymentLogs) {
        // Step 1: Craft the prompt for the GenAI model
        String prompt = buildGenAIPrompt(commitMessages, deploymentLogs);
        System.out.println("\n--- Constructed GenAI Prompt (excerpt) ---");
        System.out.println(prompt.substring(0, Math.min(prompt.length(), 500)) + "..."); // Print first 500 chars

        // Step 2: Call the GenAI API (mocked for this example)
        String rawGenAIResponse = callGenAIApi(prompt);
        System.out.println("\n--- Raw GenAI Response (Simulated) ---");
        System.out.println(rawGenAIResponse);

        // Step 3: Parse the GenAI response into a ReleaseNote object
        return parseGenAIResponse(rawGenAIResponse);
    }

    /**
     * Constructs a detailed prompt for the Generative AI model.
     * This is crucial for guiding the AI to generate desired output.
     *
     * @param commitMessages List of Git commit messages.
     * @param deploymentLogs List of deployment log entries.
     * @return A comprehensive string prompt.
     */
    private String buildGenAIPrompt(List<String> commitMessages, List<String> deploymentLogs) {
        StringBuilder promptBuilder = new StringBuilder();

        promptBuilder.append("You are an expert technical writer tasked with generating comprehensive and user-friendly release notes for a software application. ");
        promptBuilder.append("Your goal is to transform raw technical information from Git commit messages and deployment logs into clear, concise, and informative release notes. ");
        promptBuilder.append("The notes should be categorized into 'New Features', 'Bug Fixes', 'Improvements', and 'Internal/Technical Updates'.\n\n");
        promptBuilder.append("Focus on user-facing changes where possible for New Features, Bug Fixes, and Improvements. ");
        promptBuilder.append("For 'Internal/Technical Updates', provide concise summaries relevant to developers, operations, or internal stakeholders, drawing insights from deployment logs.\n\n");
        promptBuilder.append("Please format the output as a Markdown string, with clear headings and bullet points. Include a 'Version' and 'Release Date' section at the top.\n\n");
        promptBuilder.append("Here are the Git Commit Messages:\n");
        commitMessages.forEach(msg -> promptBuilder.append("- ").append(msg).append("\n"));
        promptBuilder.append("\n");

        promptBuilder.append("Here are the Deployment Logs:\n");
        deploymentLogs.forEach(log -> promptBuilder.append("- ").append(log).append("\n"));
        promptBuilder.append("\n");

        promptBuilder.append("Based on the above, generate the release notes:\n");
        promptBuilder.append("---START_RELEASE_NOTES_FORMAT---\n");
        promptBuilder.append("## Version [AUTO_GENERATE_VERSION]\n");
        promptBuilder.append("### Release Date: [CURRENT_DATE]\n\n");
        promptBuilder.append("### New Features\n");
        promptBuilder.append("- [Feature 1 Summary]\n");
        promptBuilder.append("- [Feature 2 Summary]\n\n");
        promptBuilder.append("### Bug Fixes\n");
        promptBuilder.append("- [Bug Fix 1 Summary]\n");
        promptBuilder.append("- [Bug Fix 2 Summary]\n\n");
        promptBuilder.append("### Improvements\n");
        promptBuilder.append("- [Improvement 1 Summary]\n");
        promptBuilder.append("- [Improvement 2 Summary]\n\n");
        promptBuilder.append("### Internal/Technical Updates\n");
        promptBuilder.append("- [Technical Update 1 Summary based on logs]\n");
        promptBuilder.append("- [Technical Update 2 Summary based on logs]\n");
        promptBuilder.append("---END_RELEASE_NOTES_FORMAT---");


        return promptBuilder.toString();
    }

    /**
     * Simulates a call to a Generative AI API.
     * In a real application, this would involve making an HTTP request
     * to the GenAI API endpoint, sending the prompt as part of the request body,
     * and handling the API response (e.g., using Spring's RestTemplate or WebClient).
     *
     * @param prompt The prompt string to send to the AI.
     * @return A simulated raw JSON/text response from the AI.
     */
    private String callGenAIApi(String prompt) {
        // Example of a real API call structure (conceptually):
        /*
        try {
            // Replace with actual API client or HTTP client (e.g., OkHttpClient, RestTemplate)
            // For OpenAI API, it would look something like:
            // var client = new OpenAIClient(genAIApiKey);
            // var chatCompletionRequest = ChatCompletionRequest.builder()
            //      .model(genAIApiModel)
            //      .messages(List.of(new ChatMessage("user", prompt)))
            //      .build();
            // var response = client.createChatCompletion(chatCompletionRequest);
            // return response.getChoices().get(0).getMessage().getContent();
        } catch (IOException e) {
            System.err.println("Error calling GenAI API: " + e.getMessage());
            // Fallback or re-throw
            return "Error generating notes: " + e.getMessage();
        }
        */

        // For this demo, we return a hardcoded simulated response
        // This response mimics what a well-tuned GenAI model might return
        // given the sample commit messages and deployment logs.
        String simulatedResponse = """
                ## Version 2.1.0
                ### Release Date: %s

                We're excited to announce the release of **Version 2.1.0** with several new features, bug fixes, and performance improvements!

                ### New Features
                - **User Dashboard Enhancement**: Introduced a personalized dashboard view for users to quickly access their recent activity and key metrics.
                - **Multi-Factor Authentication (MFA)**: Added support for MFA during login for enhanced security. Users can now enable MFA via their profile settings.
                - **Dark Mode Option**: Implemented a highly requested dark mode theme for a more comfortable viewing experience, especially in low-light conditions.

                ### Bug Fixes
                - Fixed an issue where the search filter was not correctly applying to date ranges, leading to inaccurate results.
                - Resolved a rare concurrency bug in the order processing module that could cause duplicate entries under heavy load.
                - Corrected a UI glitch on mobile devices where the navigation bar would sometimes overlap content.

                ### Improvements
                - Optimized database queries for the reporting module, resulting in up to 30%% faster report generation times.
                - Improved error handling and logging for API endpoints, providing clearer messages for developers.
                - Enhanced password reset flow with better user guidance and validation.

                ### Internal/Technical Updates
                - **Database Schema Update**: Applied `V1_2__add_mfa_tables.sql` migration successfully, adding new tables for MFA feature.
                - **Service Container Upgrade**: Updated 'user-service' and 'auth-service' to new container images, improving startup times and resource utilization.
                - **Configuration Refresh**: Refreshed dynamic application configurations without requiring service restarts, enabling faster adjustments.
                - **Dependency Updates**: Upgraded several internal libraries to their latest stable versions, addressing minor vulnerabilities and improving performance.
                - **CI/CD Pipeline Optimizations**: Refined the deployment pipeline to include automated pre-flight checks for database migrations.
                """.formatted(LocalDate.now());

        return simulatedResponse;
    }

    /**
     * Parses the raw string response from the GenAI API into a structured ReleaseNote object.
     * This method assumes the AI output follows a specific Markdown-like structure.
     * In a real-world scenario, you might use a more robust Markdown parser or
     * instruct the AI to output JSON for easier parsing.
     *
     * @param rawResponse The raw string response received from the GenAI API.
     * @return A populated ReleaseNote object.
     */
    private ReleaseNote parseGenAIResponse(String rawResponse) {
        // Extract version and date from the raw response (simple regex or string manipulation)
        String version = "Unknown";
        String releaseDate = LocalDate.now().toString(); // Default to current date if not found

        // Simple parsing for version and date from the first lines
        String[] lines = rawResponse.split("\n");
        if (lines.length > 0 && lines[0].startsWith("## Version ")) {
            version = lines[0].replace("## Version ", "").trim();
        }
        if (lines.length > 1 && lines[1].startsWith("### Release Date: ")) {
            releaseDate = lines[1].replace("### Release Date: ", "").trim();
        }

        // Return the parsed ReleaseNote object
        return ReleaseNote.builder()
                .version(version)
                .releaseDate(releaseDate)
                .content(rawResponse) // Keeping the full markdown content as the main body
                .build();
    }
}