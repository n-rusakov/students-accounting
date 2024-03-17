FROM openjdk:17-oracle

WORKDIR /app

COPY target/StudentsAccounting-0.0.1-SNAPSHOT.jar app.jar

ENV STD_ACS_AUTO_CREATE=true

CMD ["java", "-jar", "app.jar"]

