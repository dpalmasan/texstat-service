# TextStat Service

This service is part of the demo example on microservices patterns. This service capture text complexity metrics. It does not provide a RESTful API, but on the contrary ir provides RPC endpoints to do data processing. This processing consists on extract metircs from texts. Currently, basic matrics are implemented:

* Char count
* D-Estimate (or VOCD) diversity measurement.
* Polarity of the discourse

## Tech Stack

To implement this service, Spring Boot was used and `Maven` for dependency management. On the other hand, pluggins for `grpc` code generation where added at compile step. To start the service, you just run:

`mvn clean spring-boot:run`

To cleanly add `grpc` into the Spring Boot application [GRPC Spring Boot Starter](https://yidongnan.github.io/grpc-spring-boot-starter/) was used, as it provides flexibility to manage GRPC dependencies and add Contexts to the Spring App. In particular, with these facilities, a middleware was developed to validate authentication tokens using [go-auth-microservice](https://github.com/dpalmasan/go-auth-microservice).


## Dockerfile

Run the below command to build the image.

`docker build -t <name of image> . ` 

Here:
  name of image = We can give any name to this image.
  As we can see i have used a dot(.) in the last  of above command. basically It is use when we are working in current directory.

Run the below command to access the application.

`docker run -d -p 6000:6000 <name of image> `
 

Here:
  name of image = We can give any name to this image

### Here:
 First 6000 is mapped with the second 6000. Second port 6000 is docker container port. We are mapping these ports because now we are access the application from container.
