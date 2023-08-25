package pl.wj.bookingmanager.infrastructure.application.exception.definition;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}

