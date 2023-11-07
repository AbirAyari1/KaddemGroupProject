FROM openjdk:8-jdk-alpine
COPY target/*.jar /
EXPOSE 8089
ENTRYPOINT ["java","-jar","/*.jar"]
