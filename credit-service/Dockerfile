FROM openjdk:8-jre-alpine

VOLUME /tmp
EXPOSE 8000
COPY target/credit-service-0.0.1-SNAPSHOT.jar credit-service.jar
RUN addgroup -S newuser && adduser -S newuser -G newuser
USER newuser
ENTRYPOINT java -jar /credit-service.jar