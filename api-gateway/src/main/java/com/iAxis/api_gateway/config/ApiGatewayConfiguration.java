package com.iAxis.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aditya.chakma
 * @since 27 Jan, 2025
 */
@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange/")
                )
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion-service")
                )
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion-service")
                )
                .build();
    }

}
