package by.makedon.client.model;

import by.makedon.client.exception.WrongConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    static Logger logger = LogManager.getLogger(Client.class);
    private final int TIMEOUT = 1000;

    public boolean createSocket(String ip, int port) throws WrongConnectionException {
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            if (!inetAddress.isReachable(TIMEOUT)) {
                throw new WrongConnectionException("Connection didn't set");
            }
            clientSocket = new Socket(inetAddress, port);
            logger.log(Level.INFO, "Client connected");
            return true;
        } catch (IOException e) {
            throw new WrongConnectionException(e.getMessage());
        }
    }

    public void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            logger.log(Level.INFO, "client socket closed");
        }
    }
}