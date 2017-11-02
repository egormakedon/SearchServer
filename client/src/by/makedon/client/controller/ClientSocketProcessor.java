package by.makedon.client.controller;

import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.socket.ClientSocket;
import by.makedon.client.socket.ClientSocketInfo;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ClientSocketProcessor {
    private ClientSocket clientSocket;
    private ClientSocketInfo clientSocketInfo;
    private Timer timer;
    static Logger logger = LogManager.getLogger(ClientSocketProcessor.class);

    public ClientSocketProcessor(ClientSocket clientSocket, ClientSocketInfo clientSocketInfo) {
        this.clientSocket = clientSocket;
        this.clientSocketInfo = clientSocketInfo;
    }

    class ServerClosedTimer extends TimerTask {
        @Override
        public void run() {
            try {
                final int TIMEOUT = 1_000;
                if (!clientSocket.getClientSocket().getInetAddress().isReachable(TIMEOUT)) {
                    closeClientSocket();
                }
            } catch (IOException e) {
                logger.log(Level.WARN, e);
            }
        }
    }

    boolean isConnection() {
        return clientSocketInfo.isConnection();
    }

    void createClientSocket(String ip, int port) throws WrongConnectionException {
        if (clientSocket.createClientSocket(ip, port)) {
            clientSocketInfo.setIpPort(ip, port);
            clientSocketInfo.setConnectionTrue();

            final long DELAY = 2_000;
            timer = new Timer();
            timer.schedule(new ServerClosedTimer(), DELAY);
        }
    }

    boolean closeClientSocket() {
        if (isConnection()) {
            clientSocketInfo.setConnectionFalse();
            clientSocket.closeClientSocket();
            timer.cancel();
            return true;
        }
        return false;
    }
}
