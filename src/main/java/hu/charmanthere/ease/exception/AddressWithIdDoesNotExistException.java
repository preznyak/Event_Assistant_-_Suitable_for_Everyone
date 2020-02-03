package hu.charmanthere.ease.exception;

public class AddressWithIdDoesNotExistException extends Exception {
    public AddressWithIdDoesNotExistException(String message) {
        super(message);
    }

    public AddressWithIdDoesNotExistException() {
    }
}
