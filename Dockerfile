FROM openjdk:11-jre-slim
ADD target/kaddem-1.0.jar kaddem-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/kaddem-1.0.jar"]