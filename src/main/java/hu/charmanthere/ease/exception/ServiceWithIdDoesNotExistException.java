package hu.charmanthere.ease.exception;

public class ServiceWithIdDoesNotExistException extends Exception {
    public ServiceWithIdDoesNotExistException(String message) {
        super(message);
    }

    public ServiceWithIdDoesNotExistException() {
    }
}
