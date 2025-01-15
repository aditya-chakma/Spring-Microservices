package com.iaxis.Spring.microsevices.helloWorld;

import com.iaxis.Spring.microsevices.helloWorld.dto.HelloWorldDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 11:13 AM
 */
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    @Autowired
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("/hello-world-i18n")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
