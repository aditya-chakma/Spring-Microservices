package com.iaxis.Spring.microsevices.helloWorld;

import com.iaxis.Spring.microsevices.helloWorld.dto.HelloWorldDto;
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

    @GetMapping(value = "/helloWorld", headers = "X-API-VERSION=1")
    public String helloWorldV1Header() {
        return "Hello world header v1";
    }

    @GetMapping(value = "/helloWorld", headers = "X-API-VERSION=2")
    public String helloWorldV2Header() {
        return "Hello world header v2";
    }

    @GetMapping(value = "/helloWorld", produces = "application/vnd.company.app-v1+json")
    public HelloWorldDto helloWorldV1ContentNegotiate() {
        return new HelloWorldDto("Hello world content v1");
    }

    @GetMapping(value = "/helloWorld", produces = "application/vnd.company.app-v2+json")
    public HelloWorldDto helloWorldV2ContentNegotiate() {
        return new HelloWorldDto("Hello world content v2");
    }

}
