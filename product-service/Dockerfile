FROM openjdk:8-jre-alpine

VOLUME /tmp
ADD target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
RUN addgroup -S newuser && adduser -S newuser -G newuser
USER newuser
ENTRYPOINT java -jar /product-service.jar