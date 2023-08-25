package pl.wj.bookingmanager.infrastructure.exception.definition;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

