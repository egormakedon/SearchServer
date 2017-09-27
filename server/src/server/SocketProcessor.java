package server;

import sessionModel.SessionModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketProcessor implements Runnable {
    private InputStream inS = null;
    private OutputStream outS = null;
    private Socket socket = null;

    private SessionModel sessionModel = null;

    SocketProcessor(Socket socket, SessionModel sessionModel) throws IOException {
        this.socket = socket;
        this.inS = socket.getInputStream();
        this.outS = socket.getOutputStream();

        this.sessionModel = sessionModel;
    }

    @Override
    public void run() {
        if (!checkSocketSessionOnExist(socket)) {
            addSocketToList(socket);
        }
    }

    private boolean checkSocketSessionOnExist(Socket socket) {
        return sessionModel.checkSocketExistInList(socket);
    }

    private void addSocketToList(Socket socket) {
        sessionModel.addSocketToList(socket);
    }
}
