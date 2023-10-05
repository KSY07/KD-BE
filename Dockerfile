FROM openjdk:17-ea-11-jdk-slim
WORKDIR /app
COPY target/kdbe-1.0.jar kdbe.jar
ENTRYPOINT ["java", "-jar", "kdbe.jar"]