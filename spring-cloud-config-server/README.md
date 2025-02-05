# Config server

This repo is part of Spring Cloud. Config server is used to manage configurations for multiuple microservices. Managing separate configuration for separate microservices is a cumbersome task. Config server helps by managing the configurations from a central server.

## Getting started

Go through [this](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/) article to get started.

## Dependencies

For this we will need spring cloud config server. Add the following in the `pom.xml` file:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

and we are using java 21 and spring cloud version 2024.

```xml
<properties>
    <java.version>21</java.version>
    <spring-cloud.version>2024.0.0</spring-cloud.version>
</properties>
```

## Configuration

Now we need to read configuration from a repository. This can be a remote repository. For this let's create a repository containing all the configurations. First create a folder

```sh
mkdir git-config
cd git-config
git init
```

> Or you can use an existing repository of the configurations.

Remember ***config server reads configuration from a repository. The repository might contain multiple branches, but the configuration is read from the master branch by default***. You can change the default branch name in the properties.

Now let's create a configuration file inside `git-config` name it `limits-service.properties`. Be sure to name the config file name exactly same as the application name. In this case we have an application called limits-service. Here, we will only demonstrate how to create, and configure a config server. For client side configuration please see the following repo:

- [Limits Service](../limits-service/README.md)

We will run our config-server application at port **8888**. And let's say we have put our configuration in a remote repo. The put the following properties in the `application.properties` file.

```properties
spring.application.name=spring-cloud-config-server
server.port=8888

# config
spring.cloud.config.server.git.uri=https://github.com/aditya-chakma/demo-config-repo.git
```

> Note: the following repo is private. Used for demonstration purpose only

If you need to read the configuration from a specific branch, you can mention it inside the `applicaiton.properties`.

```properties
spring.cloud.config.label=dev-test
```

By default it will read configurations from `master` branch.
