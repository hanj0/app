FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/*SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]