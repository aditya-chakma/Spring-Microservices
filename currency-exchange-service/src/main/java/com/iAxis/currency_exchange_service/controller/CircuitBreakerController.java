package com.iAxis.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author aditya.chakma
 * @since 03 Feb, 2025
 */
@RestController
public class CircuitBreakerController {

    private final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/default-response")
//    @Retry(name = "default", fallbackMethod = "defaultFailedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "defaultFailedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String getDefaultResponse() {
        log.info("Default API call receiver");

        //new RestTemplate().getForEntity("http://localhost:8080://dummy-api", String.class);
        return "Currency exchange service";
    }

    public String defaultFailedResponse(Exception ex) {
        return "Failed to call default Response";
    }

}
