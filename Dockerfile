# stage 1: build
FROM maven:3.10.1-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src
RUN mvn -B -DskipTests package

# stage 2: runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
