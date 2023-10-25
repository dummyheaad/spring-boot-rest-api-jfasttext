FROM openjdk:17

WORKDIR /usr/src/app
COPY . .

ENTRYPOINT ["java", "-jar", "./target/restapijfasttext-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
