FROM openjdk:11-jre-slim
RUN addgroup --system spring && adduser --system --group spring 
USER spring:spring
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/textat-service.jar
EXPOSE 6000
ENTRYPOINT ["java","-jar","textat-service.jar"]