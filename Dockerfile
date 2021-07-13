#Author VSRV Raghavan (vsrv.raghavan@swan-speed.com)
FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG WAR_FILE
#COPY ${WAR_FILE} app.war
COPY ./target/ecommerce-rest-api-1.0.0.war app.war
ENTRYPOINT ["java","-jar","app.war"]
