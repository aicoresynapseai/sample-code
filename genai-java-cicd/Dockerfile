# GenAI would generate an optimized multi-stage Dockerfile based on the Java project type (Spring Boot)
# and specified deployment environment (Kubernetes).

# --- Stage 1: Build the application ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
# GenAI would analyze pom.xml for dependencies and cache strategy
WORKDIR /app
COPY pom.xml .
# GenAI might suggest pre-fetching dependencies to optimize layer caching
RUN mvn dependency:go-offline -B

COPY src ./src
# GenAI infers the build command for Maven
RUN mvn clean package -DskipTests

# --- Stage 2: Create the final lightweight image ---
FROM eclipse-temurin:17-jre-focal
# GenAI selects a minimal JRE image for production deployment
WORKDIR /app

# GenAI infers the application JAR from the build output
COPY --from=build /app/target/genai-java-cicd-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot typically runs on (8080)
EXPOSE 8080

# GenAI automatically determines the entry point for Spring Boot applications
ENTRYPOINT ["java", "-jar", "app.jar"]

# GenAI might add security hardening suggestions:
# USER nonroot
# And health checks for robust deployments:
# HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl --fail http://localhost:8080/actuator/health || exit 1