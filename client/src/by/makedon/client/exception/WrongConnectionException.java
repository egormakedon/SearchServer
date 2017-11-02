package by.makedon.client.exception;

public class WrongConnectionException extends Exception {
    public WrongConnectionException() {

    }

    public WrongConnectionException(String m) {
        super(m);
    }

    public WrongConnectionException(String m, Throwable e) {
        super(m, e);
    }

    public WrongConnectionException(Throwable e) {
        super(e);
    }
}