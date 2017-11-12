package by.makedon.client.socket;

import by.makedon.client.exception.WrongConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {
    private Socket clientSocket;
    private ObjectOutputStream objos;
    private ObjectInputStream objis;
    static Logger logger = LogManager.getLogger(ClientSocket.class);

    public boolean createClientSocket(String ip, int port) throws WrongConnectionException {
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            clientSocket = new Socket(inetAddress, port);
            OutputStream os = clientSocket.getOutputStream();
            InputStream is = clientSocket.getInputStream();
            objos = new ObjectOutputStream(os);
            objis = new ObjectInputStream(is);
            logger.log(Level.INFO, "ClientSocket connected");
            return true;
        } catch (IOException e) {
            throw new WrongConnectionException("Connection didn't set", e);
        }
    }

    public void closeClientSocket() {
        if (objos != null) {
            try {
                objos.close();
                objos = null;
            } catch (IOException e) {
                logger.log(Level.ERROR, e);
            }
        }
        if (objis != null) {
            try {
                objis.close();
                objis = null;
            } catch (IOException e) {
                logger.log(Level.ERROR, e);
            }
        }
        if (clientSocket != null) {
            try {
                clientSocket.close();
                clientSocket = null;
                logger.log(Level.INFO, "ClientSocket was closed");
            } catch (IOException e) {
                logger.log(Level.ERROR, e);
            }
        }
    }

    public ObjectOutputStream getObjos() {
        return objos;
    }

    public ObjectInputStream getObjis() {
        return objis;
    }
}