FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# make image : docker build -t spring-boot:latest .
# docker run -d -p 8080:8080 --name spring-boot-container spring-boot:latest