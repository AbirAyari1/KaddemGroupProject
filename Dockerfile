FROM openjdk:11-jre-slim
ADD target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/kaddem-0.0.1-SNAPSHOT.jar"]