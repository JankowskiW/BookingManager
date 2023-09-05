package pl.wj.bookingmanager.infrastructure.exception.definition;

public class MapperException extends RuntimeException {
    // TODO: change every null return in mappers to throwing that exception
    public MapperException(String message) {
        super(message);
    }
}