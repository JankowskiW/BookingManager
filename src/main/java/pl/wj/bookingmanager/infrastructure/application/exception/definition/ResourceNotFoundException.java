package pl.wj.bookingmanager.infrastructure.application.exception.definition;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

