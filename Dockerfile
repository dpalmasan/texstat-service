FROM openjdk:11

EXPOSE 6002

ADD target/TextStatService-0.0.1-SNAPSHOT.jar TextStatService-0.0.1-SNAPSHOT.jar


CMD ["java","-jar","TextStatService-0.0.1-SNAPSHOT.jar"]