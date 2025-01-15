package com.iaxis.Spring.microsevices.helloWorld.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025 3:08 PM
 */
public class HelloWorldDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    public HelloWorldDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
