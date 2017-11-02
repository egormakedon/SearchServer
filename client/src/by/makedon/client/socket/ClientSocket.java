package by.makedon.client.socket;

import by.makedon.client.exception.WrongConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {
    private Socket clientSocket;
    static Logger logger = LogManager.getLogger(ClientSocket.class);

    public boolean createClientSocket(String ip, int port) throws WrongConnectionException {
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            final int TIMEOUT = 1000;
            if (!inetAddress.isReachable(TIMEOUT)) {
                throw new WrongConnectionException("Connection didn't set");
            }
            clientSocket = new Socket(inetAddress, port);
            logger.log(Level.INFO, "ClientSocket connected");
            return true;
        } catch (IOException e) {
            throw new WrongConnectionException("ClientSocket io exception", e);
        }
    }

    public void closeClientSocket() {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) clientSocket.close();
        } catch (IOException e) {
            logger.log(Level.WARN, "ClientSocket io exception", e);
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}