package hu.charmanthere.ease.exception;

public class ContactWithIdDoesNotExistException extends Exception {
    public ContactWithIdDoesNotExistException(String message) {
        super(message);
    }

    public ContactWithIdDoesNotExistException() {
    }
}
