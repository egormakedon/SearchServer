package by.makedon.server.exception;

public class SocketException extends Exception {
    public SocketException() {

    }

    public SocketException(String m, Throwable th) {
        super(m ,th);
    }

    public SocketException(String m) {
        super(m);
    }

    public SocketException(Throwable th) {
        super(th);
    }
}
