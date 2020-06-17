FROM openjdk:8-jdk-alpine

MAINTAINER murshidhassen

ADD ./build/libs/backend-1.0-SNAPSHOT.jar ./full-teaching.jar

EXPOSE 5001

ENTRYPOINT ["java","-jar","/full-teaching.jar"]
