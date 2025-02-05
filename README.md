# Spring Microservices

Spring microservices practice and excercise. This repo contains multiple components from the Spring Framework.

## Spring Recap

Spring MVC withour Boot.

## Spring Cloud

Components of Spring cloud.

### Config Server

Spring cloud config server and client enables microservices to manage their configuration in a centralized manner. This is achieved through a config server that stores the configuration in a Git repository. The config server exposes a REST API that allows clients to retrieve their configuration. The client can then use the retrieved configuration to initialize its application context. Please watch the following repos for demo:

- Config Serve. [Spring cloud config server](./spring-cloud-config-server/README.md)
- Config Client [Limits service](./limits-service/README.md)

### Netflix Eureka (Discovery Server)

- Feign Server
- Feign Clients

### API-Gateway

- Router

### Circuit Breaker
<!-- Details -->
- Rate Limiter
- Retry
- Ciruit Breaker

### Docker

The demo docker repo can be found [here](./docker/hello-world/)

- Install Docker
- Launch app in a docker container
- Create a docker image
- Optimize docker script
