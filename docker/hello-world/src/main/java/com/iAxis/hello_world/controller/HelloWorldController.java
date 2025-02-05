package com.iAxis.hello_world.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 05 Feb, 2025
 */
@RestController
public class HelloWorldController {

    @GetMapping({"", "/"})
    public String helloWorld() {
        return "Hello World!";
    }

}
