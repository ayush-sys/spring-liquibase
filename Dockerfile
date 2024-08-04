# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/spring-liquibase-0.0.1-SNAPSHOT.jar /app/spring-liquibase.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/spring-liquibase.jar"]
