FROM openjdk:8-jre-alpine

VOLUME /tmp
ADD target/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar
RUN addgroup -S newuser && adduser -S newuser -G newuser
USER newuser
ENTRYPOINT java -jar /customer-service.jar