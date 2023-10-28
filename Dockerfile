FROM openjdk:8-jdk-alpine
EXPOSE 8089
RUN apk --no-cache add curl
RUN curl -u admin:0000 -o achat.jar "http://192.168.1.5:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar" -L
#ADD http://192.168.1.5:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar -L
ENTRYPOINT ["java","-jar","/kaddem-1.0.jar"]
