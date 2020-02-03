package hu.charmanthere.ease.exception;

public class ContactWithIdDoesNotExist extends Exception {
    public ContactWithIdDoesNotExist(String message) {
        super(message);
    }

    public ContactWithIdDoesNotExist() {
    }
}
