package hu.charmanthere.ease.exception;

public class OfferWithIdDoesNotExistException extends Throwable {
    public OfferWithIdDoesNotExistException(String message) {
        super(message);
    }

    public OfferWithIdDoesNotExistException() {
    }
}
