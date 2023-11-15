FROM openjdk:11-jre-slim
ADD target/kaddem-0.0.1.jar kaddem-0.0.1.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/kaddem-0.0.1.jar"]