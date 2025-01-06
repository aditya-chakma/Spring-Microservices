package com.iaxis.Spring.microsevices.user.helper;

import com.iaxis.Spring.microsevices.exception.APIErrorDetails;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.stream.Collectors;

/**
 * @author aditya.chakma
 * @since 06 Jan, 2025
 */
@Component
public class UserHelper {

    public APIErrorDetails getErrorDetails(BindingResult result) {
        if (!result.hasErrors()) {
            return null;
        }

        StringBuilder sb = new StringBuilder("Count: " + result.getErrorCount() + "\n")
                .append("Errors: ")
                .append(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(","))
                )
                .append("\n");

        return new APIErrorDetails(
                LocalDate.now(),
                "Errors Found",
                sb.toString()

        );
    }

}
