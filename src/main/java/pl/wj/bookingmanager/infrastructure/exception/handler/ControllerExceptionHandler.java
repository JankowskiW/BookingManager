package pl.wj.bookingmanager.infrastructure.exception.handler;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.wj.bookingmanager.infrastructure.exception.body.ExceptionBody;
import pl.wj.bookingmanager.infrastructure.exception.definition.BadRequestException;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceAlreadyExistsException;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

import java.time.ZonedDateTime;

@RestControllerAdvice
@Log4j2
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleResourceNotFoundException(ResourceNotFoundException e) {
        return handleException(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionBody handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return handleException(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleBadRequestException(BadRequestException e) {
        return handleException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionBody handleBadCredentialsException(BadCredentialsException e) {
        return handleException(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    private ExceptionBody handleException(String message, HttpStatus httpStatus) {
        ExceptionBody response = new ExceptionBody(message, httpStatus, ZonedDateTime.now());
        log.error(String.format("[%s]: %s", response.httpStatus(), response.message()));
        return response;
    }
}