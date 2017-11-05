package by.makedon.client.controller;

import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.exception.WrongDataInputException;
import by.makedon.client.socket.ClientSocket;
import by.makedon.client.socket.ClientSocketInfo;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    List<String> getConnectionInfo() {
        List<String> connectionInfoList = new ArrayList<String>();
        connectionInfoList.add(clientSocketInfo.getIp());
        connectionInfoList.add(Integer.toString(clientSocketInfo.getPort()));
        return connectionInfoList;
    }

    List<String> findPersonInformation(final String QUERY) throws WrongConnectionException, WrongDataInputException {
        ObjectOutputStream objos = null;
        ObjectInputStream objis = null;
        List<String> personInformation = null;
        try {
            OutputStream os = clientSocket.getClientSocket().getOutputStream();
            InputStream is = clientSocket.getClientSocket().getInputStream();
            objos = new ObjectOutputStream(os);
            objis = new ObjectInputStream(is);
            final String KEY = "PERSONINFORMATION";

            objos.flush();
            objos.writeObject(KEY);
            objos.flush();
            objos.writeObject(QUERY);
            objos.flush();

            personInformation = (ArrayList<String>) objis.readObject();
        } catch (IOException e) {
            throw new WrongConnectionException("Stream haven't opened", e);
        } catch (ClassNotFoundException e) {
            throw new WrongConnectionException("Object haven't read from Stream", e);
        } finally {
            if (objos != null) {
                try {
                    objos.close();
                } catch (IOException e) {
                    logger.log(Level.WARN, e);
                }
            }
            if (objis != null) {
                try {
                    objis.close();
                } catch (IOException e) {
                    logger.log(Level.WARN, e);
                }
            }
        }
        if (personInformation != null) {
            return personInformation;
        } else {
            throw new WrongDataInputException("Have took wrong object");
        }
    }
}
