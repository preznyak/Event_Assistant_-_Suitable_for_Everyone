package hu.charmanthere.ease.exception;

public class GuestWithIdDoesNotExistException extends Throwable {
    public GuestWithIdDoesNotExistException(String message) {
        super(message);
    }

    public GuestWithIdDoesNotExistException() {
    }
}
