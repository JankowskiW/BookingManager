package pl.wj.bookingmanager.infrastructure.exception.definition;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
