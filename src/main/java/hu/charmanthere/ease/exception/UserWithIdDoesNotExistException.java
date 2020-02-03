package hu.charmanthere.ease.exception;

public class UserWithIdDoesNotExistException extends Exception {
    public UserWithIdDoesNotExistException(String message) {
        super(message);
    }

    public UserWithIdDoesNotExistException() {
    }
}
