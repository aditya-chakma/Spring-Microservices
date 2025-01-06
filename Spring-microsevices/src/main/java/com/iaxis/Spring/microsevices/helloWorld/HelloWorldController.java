package com.iaxis.Spring.microsevices.helloWorld;

import com.iaxis.Spring.microsevices.helloWorld.dto.HelloWorldDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 11:13 AM
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-dto")
    public HelloWorldDto helloWorldDto() {
        return new HelloWorldDto("Hello world DTO!!!");
    }

    @GetMapping("/hello-world-dto/{name}")
    public HelloWorldDto helloWorldDto(@PathVariable String name) {
        return  new HelloWorldDto(String.format("Hello %s", name));
    }
}
