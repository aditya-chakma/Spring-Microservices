# Limits Service

A demo microservices application and a config client. This repo contains example of how to read configuration from a config server. For details of config server goto this [repo](../spring-cloud-config-server/README.md).

## Dependencies

- Spring Boot
- Spring Web
- Spring Cloud Config Client

## Reading application.properties Programmatically

You can read properties defined in `application.properties` using the `@Value` annotation or by using the `Environment` object. For example:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {

    @Value("${some.property}")
    private String someProperty;

    // Use someProperty in your methods
}
```

## Using Another Properties File

By default, the application will read from `app-host.properties` instead of `application.properties`. To make Spring read from another properties file, you can specify the file in the `@PropertySource` annotation:

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app-host.properties")
public class AppConfig {
    // Configuration beans
}
```

## Spring Cloud Config Client

To use Spring Cloud Config Client, add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

Make sure to configure the `application.properties` to point to your config server:

```properties
spring.config.import=optional:configserver:http://localhost:8888
```

The optional tag is used to indicate that the config server is not required for the application to start. If we do not mention this, the application will not start if the config server is not available.

## Important Configurations for Spring Cloud Config Client

- `spring.cloud.config.uri`: The URL of the config server.
- `spring.application.name`: The name of your application, which will be used to fetch the configuration.
- `spring.cloud.config.label`: (Optional) The label of the configuration to use (e.g., branch name in Git).

## Profiling Details

To enable profiling for the Spring Config client, you can set the following property in your `application.properties` or `app-host.properties`:

```properties
spring.profiles.active=dev
spring.cloud.config.profile=dev
```

This will activate the `dev` profile, allowing you to load environment-specific configurations.

This README provides a basic overview of the limits service and how to work with configuration in Spring Boot and Spring Cloud.
