package by.makedon.client.exception;

public class WrongConnectionException extends Exception {
    public WrongConnectionException() {

    }

    public WrongConnectionException(String message) {
        super(message);
    }

    public WrongConnectionException(String message, Throwable exception) {
        super(message, exception);
    }

    public WrongConnectionException(Throwable exception) {
        super(exception);
    }
}
