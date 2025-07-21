# GenAI generates an optimized multi-stage Dockerfile for Java Spring Boot apps.
# This ensures a smaller final image size and faster builds.

# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-focal as builder
# GenAI selects an appropriate JDK version and base image for Java builds.
# It often prefers 'temurin' for open-source compliance and widespread use.

WORKDIR /app

# Copy Maven wrapper and project files first to leverage Docker cache
# GenAI optimizes layer caching by copying dependencies first
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline # Pre-download dependencies to speed up subsequent builds

# Copy source code
COPY src ./src

# Build the application
# GenAI knows the standard Maven build command for Spring Boot apps
RUN ./mvnw clean install -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jre-focal
# GenAI chooses a JRE-only image for the final stage, reducing image size.

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar
# GenAI ensures the correct JAR file is copied for execution.

# Expose the port Spring Boot typically runs on
EXPOSE 8080
# GenAI automatically identifies the application's port.

# Set entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
# GenAI correctly configures the command to run the Spring Boot application.

# Additional considerations GenAI might include:
# - Adding non-root user for security (e.g., USER springboot:springboot)
# - Setting JAVA_TOOL_OPTIONS for memory tuning (e.g., -XX:MaxRAMPercentage=75.0)
# - Including health check commands if running on Kubernetes