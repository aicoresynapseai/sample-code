# This Dockerfile is an example of what a Generative AI
# would produce for a Spring Boot Java application.
# GenAI optimizes for multi-stage builds and small image size.

# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-jammy AS build # GenAI selects appropriate base image and Java version
WORKDIR /app
COPY pom.xml . # GenAI knows to copy Maven project files
COPY src ./src
RUN mvn clean package -DskipTests # GenAI knows the build command and skips tests for faster image build

# Stage 2: Create the final lean image
FROM eclipse-temurin:17-jre-jammy # GenAI optimizes for JRE only for smaller runtime image
WORKDIR /app
# Copy only the compiled JAR from the build stage
COPY --from=build /app/target/*.jar app.jar # GenAI correctly identifies the JAR artifact
EXPOSE 8080 # GenAI exposes the default Spring Boot port
ENTRYPOINT ["java", "-jar", "app.jar"] # GenAI generates the correct entrypoint command for Spring Boot