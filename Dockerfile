FROM openjdk:17-jdk-slim
VOLUME /tmp
RUN ./mvnw clean package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]