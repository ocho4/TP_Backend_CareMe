#Construcción
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Construimos el .jar saltando los tests para acelerar el despliegue
RUN mvn clean package -DskipTests


#Ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
# El nombre del JAR debe coincidir con tu artifactId y versión del pom.xml
COPY --from=build /app/target/careme-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]