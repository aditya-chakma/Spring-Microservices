package com.iaxis.Spring.microsevices.helloWorld;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 12 Jan, 2025 10:02 AM
 */
@RestController
public class VersionedHelloWorld {

    @GetMapping("/v1/helloWorld")
    public String helloWorldV1() {
        return "Hello world uri v1";
    }

    @GetMapping("/v2/helloWorld")
    public String helloWorldV2() {
        return "Hello world uri v2";
    }

    @GetMapping(value = "/helloWorld", params = "version=1")
    public String helloWorldV1Param() {
        return "Hello world param v1";
    }

    @GetMapping(value = "/helloWorld", params = "version=2")
    public String helloWorldV2Param() {
        return "Hello world param v2";
    }

}
