# GenAI automatically generates optimized multi-stage Dockerfiles for Java apps.

# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-focal AS build
# GenAI selects the appropriate JDK version and base image.

WORKDIR /app

# Copy the Maven wrapper and pom.xml first to leverage Docker layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
# GenAI understands Maven project structure and dependencies for efficient caching.

# Download project dependencies, only re-run if pom.xml changes
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the application code
COPY src src

# Build the Spring Boot application
RUN ./mvnw clean install -DskipTests

# Stage 2: Create the final lightweight image
FROM eclipse-temurin:17-jre-focal
# GenAI switches to a smaller JRE-only image for the final production container.

WORKDIR /app

# Expose the port on which the Spring Boot application runs (default 8080)
EXPOSE 8080
# GenAI infers the application port from Spring Boot conventions or configuration.

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar
# GenAI correctly identifies the build artifact path and copies it.

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
# GenAI sets the correct command to run the Java application.