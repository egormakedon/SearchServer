package by.makedon.server.exception;

public class ServerException extends Exception {
    public ServerException() {

    }

    public ServerException(String m, Throwable th) {
        super(m, th);
    }

    public ServerException(String m) {
        super(m);
    }

    public ServerException(Throwable th) {
        super(th);
    }
}
