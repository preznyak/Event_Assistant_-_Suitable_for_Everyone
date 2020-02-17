package hu.charmanthere.ease.exception;

public class CommentWithIdDoesNotExistException extends Exception{
    public CommentWithIdDoesNotExistException(String message) {
        super(message);
    }

    public CommentWithIdDoesNotExistException() {
    }
}
