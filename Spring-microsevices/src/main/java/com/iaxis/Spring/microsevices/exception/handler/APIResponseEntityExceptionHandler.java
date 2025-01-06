package com.iaxis.Spring.microsevices.exception.handler;

import com.iaxis.Spring.microsevices.exception.APIErrorDetails;
import com.iaxis.Spring.microsevices.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025
 */
@ControllerAdvice
public class APIResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<APIErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        APIErrorDetails apiErrorDetails = new APIErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(apiErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<APIErrorDetails> handleUserNotFound(Exception ex, WebRequest request) {
        APIErrorDetails apiErrorDetails = new APIErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(apiErrorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        APIErrorDetails apiErrorDetails = new APIErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(apiErrorDetails, HttpStatus.BAD_REQUEST);
    }

}
