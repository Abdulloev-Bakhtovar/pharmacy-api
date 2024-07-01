FROM maven:3.9.7-eclipse-temurin-21 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=builder /app/target/eureka-server-0.0.1-SNAPSHOT.jar ./eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
