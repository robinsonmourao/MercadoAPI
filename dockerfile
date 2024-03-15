FROM openjdk

WORKDIR /app

COPY target/Mercado-0.0.1-SNAPSHOT.jar /app/mercado-api.jar

ENTRYPOINT ["java", "-jar", "mercado-api.jar"]