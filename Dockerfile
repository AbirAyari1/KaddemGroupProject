FROM openjdk:11-jdk-alpine
EXPOSE 8089
RUN apk --no-cache add curl
RUN curl -u admin:191JFT4357 -o achat.jar "http://172.20.10.5:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar" -L
ENTRYPOINT ["java","-jar","/kaddem-1.0.jar"]
