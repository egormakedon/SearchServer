package by.makedon.server.exception;

public class StreamException extends Exception {
    public StreamException() {

    }

    public StreamException(String m, Throwable th) {
        super(m, th);
    }

    public StreamException(String m) {
        super(m);
    }

    public StreamException(Throwable th) {
        super(th);
    }
}
