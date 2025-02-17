# Stage 1: Build the application
FROM maven:3.9.9-ibm-semeru-23-jammy AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21.0.6_7-jre-ubi9-minimal
WORKDIR /app
COPY --from=build /app/target/*-jar-with-dependencies.jar climax.jar

# Set the environment variable for API Key (can be overridden at runtime)
ENV CLIMAX_API_KEY=""

ENTRYPOINT ["java", "-jar", "climax.jar"]
CMD ["40.7128", "-74.0060"]