# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Information around who maintains the image
MAINTAINER Ken Harmon

# Add the application's jar to the image
COPY target/rechub-0.0.1-SNAPSHOT.jar rechub-0.0.1-SNAPSHOT.jar

# Command to execute the application
ENTRYPOINT ["java", "-jar", "rechub-0.0.1-SNAPSHOT.jar"]