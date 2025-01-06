package com.iaxis.Spring.microsevices.exception;

import java.time.LocalDate;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025
 */
public class APIErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String details;

    public APIErrorDetails(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
