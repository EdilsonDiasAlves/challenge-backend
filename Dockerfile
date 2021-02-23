FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} challenge-backend.jar
ENTRYPOINT ["java","-jar","/challenge-backend.jar"]