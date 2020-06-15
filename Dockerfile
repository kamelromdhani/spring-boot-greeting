FROM openjdk:8-jdk-alpine
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
#RUN mvn package -DskipTests