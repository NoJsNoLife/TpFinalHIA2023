FROM maven:3.6-openjdk-17-slim AS builder
WORKDIR /app 
COPY pom.xml . 
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B -DskipTests package

FROM openjdk:17-alpine
COPY --from=builder /app/target/grupo01_HIA_TPFinal-0.0.1-SNAPSHOT.jar /
CMD ["java", "-jar", "/grupo01_HIA_TPFinal-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
