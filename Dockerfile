FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY target/kdbe-0.0.1-SNAPSHOT.jar kdbe.jar
ENTRYPOINT ["java", "-jar", "kdbe.jar"]