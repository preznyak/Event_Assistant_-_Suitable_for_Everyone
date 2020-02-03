package hu.charmanthere.ease.exception;

public class ContractWithIdDoesNotExistException extends Exception {
    public ContractWithIdDoesNotExistException(String message) {
        super(message);
    }

    public ContractWithIdDoesNotExistException() {
    }
}
