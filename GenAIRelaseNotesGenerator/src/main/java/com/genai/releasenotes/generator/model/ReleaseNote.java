package com.genai.releasenotes.generator.model;

import lombok.Builder;
import lombok.Data;

/**
 * Data class representing the auto-generated release notes.
 * Uses Lombok annotations for boilerplate reduction.
 */
@Data // Generates getters, setters, toString, equals, and hashCode
@Builder // Provides a builder pattern for object creation
public class ReleaseNote {
    private String version;
    private String releaseDate;
    private String content;

    // Additional fields could be added here based on requirements, e.g.:
    // private List<String> newFeatures;
    // private List<String> bugFixes;
    // private List<String> improvements;
    // private String generatedByAIModel;
}