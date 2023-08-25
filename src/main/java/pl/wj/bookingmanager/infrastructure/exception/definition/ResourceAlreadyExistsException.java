package pl.wj.bookingmanager.infrastructure.exception.definition;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}

