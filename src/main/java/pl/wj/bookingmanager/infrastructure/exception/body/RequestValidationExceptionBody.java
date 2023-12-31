package pl.wj.bookingmanager.infrastructure.exception.body;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

public record RequestValidationExceptionBody(
        List<String> messages,
        HttpStatus status,
        ZonedDateTime timestamp
) {}