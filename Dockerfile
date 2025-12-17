FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/student-notes-sharing-1.0.jar app.jar

EXPOSE 4567

CMD ["java", "-jar", "app.jar"]

