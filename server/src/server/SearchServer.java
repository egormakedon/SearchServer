package server;

import sessionModel.SessionModel;

import java.net.ServerSocket;
import java.net.Socket;

public class SearchServer {
    private final int PORT = 9000;
    private ServerSocket ss = null;

    private SessionModel sessionModel = null;

    public void runServer() throws Throwable {
        ss = new ServerSocket(PORT);
        while(true) {
            Socket socket = ss.accept();
            new Thread(new SocketProcessor(socket, sessionModel)).run();
        }
    }

    public void setSessionModel(SessionModel sessionModel) {
        this.sessionModel = sessionModel;
    }
}