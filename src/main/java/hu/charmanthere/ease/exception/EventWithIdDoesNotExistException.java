package hu.charmanthere.ease.exception;

public class EventWithIdDoesNotExistException extends Exception{
    public EventWithIdDoesNotExistException(String message) {
        super(message);
    }

    public EventWithIdDoesNotExistException() {
    }
}
