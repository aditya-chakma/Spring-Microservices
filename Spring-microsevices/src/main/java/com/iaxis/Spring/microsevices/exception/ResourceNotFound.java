package com.iaxis.Spring.microsevices.exception;

/**
 * @author aditya.chakma
 * @since 14 Jan, 2025
 */
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
