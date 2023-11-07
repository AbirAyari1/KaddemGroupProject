FROM openjdk:8-alpine
COPY target/*.jar /
EXPOSE 8089
ENTRYPOINT ["java","-jar","/kaddem-1.0.jar"]
