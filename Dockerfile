# Stage 1: Build the application (optional, comment out if JAR already exists)
#FROM maven:3.9.6-jdk-alpine AS builder
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml ./
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar .
EXPOSE 8080
# Change if your app uses a different port
ENTRYPOINT ["java", "-jar", "school-library-0.0.1-SNAPSHOT.jar"]
