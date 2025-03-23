# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Information around who maintains the image
LABEL authors=KenHarmon

ENV RAWG_API_KEY=${RAWG_API_KEY}

# Add the application's jar to the image
COPY target/rechub-0.0.1-SNAPSHOT.jar app.jar

# Command to execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]