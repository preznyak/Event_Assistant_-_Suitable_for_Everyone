package hu.charmanthere.ease.exception;

public class UserWithEmailDoesNotExistException extends Exception {
    public UserWithEmailDoesNotExistException(String message) {
        super(message);
    }

    public UserWithEmailDoesNotExistException() {
    }
}
