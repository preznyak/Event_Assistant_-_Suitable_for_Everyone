package hu.charmanthere.ease.exception;

public class ArticleWithIdDoesNotExistException extends Exception {
    public ArticleWithIdDoesNotExistException(String message) {
        super(message);
    }

    public ArticleWithIdDoesNotExistException() {
    }

}
