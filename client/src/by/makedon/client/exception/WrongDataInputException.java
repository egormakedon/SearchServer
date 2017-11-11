package by.makedon.client.exception;

public class WrongDataInputException extends Exception {
    public WrongDataInputException() {

    }

    public WrongDataInputException(String m) {
        super(m);
    }

    public WrongDataInputException(String m, Throwable th) {
        super(m, th);
    }

    public WrongDataInputException(Throwable th) {
        super(th);
    }
}