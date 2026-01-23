FROM eclipse-temurin:21-alpine

WORKDIR /produtosapi

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
