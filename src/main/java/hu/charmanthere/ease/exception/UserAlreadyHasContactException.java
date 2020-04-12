package hu.charmanthere.ease.exception;

public class UserAlreadyHasContactException extends Throwable {

    public UserAlreadyHasContactException(String message) {
        super(message);
    }

    public UserAlreadyHasContactException() {
    }
}
