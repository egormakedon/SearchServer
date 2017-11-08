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
    static Logger logger = LogManager.getLogger(ClientSocketProcessor.class);

    public ClientSocketProcessor(ClientSocket clientSocket, ClientSocketInfo clientSocketInfo) {
        this.clientSocket = clientSocket;
        this.clientSocketInfo = clientSocketInfo;
    }

//    class ClientClosedTimer extends TimerTask {
//        @Override
//        public void run() {
//            try {
//                final int TIMEOUT = 1_000;
//                if (!clientSocket.getClientSocket().getInetAddress().isReachable(TIMEOUT)) {
//                    closeClientSocket();
//                }
//            } catch (IOException e) {
//                logger.log(Level.WARN, e);
//            }
//        }
//    }

    boolean isConnection() {
        return clientSocketInfo.isConnection();
    }

    void createClientSocket(String ip, int port) throws WrongConnectionException {
        if (clientSocket.createClientSocket(ip, port)) {
            clientSocketInfo.setIpPort(ip, port);
            clientSocketInfo.setConnectionTrue();

//            final long DELAY = 2_000;
//            timer = new Timer();
//            timer.schedule(new ServerClosedTimer(), DELAY);
        }
    }

    boolean closeClientSocket() {
        if (isConnection()) {
            clientSocketInfo.setConnectionFalse();
            clientSocket.closeClientSocket();
//            timer.cancel();
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
        List<String> personInformation;
        final String KEY = "PERSONINFORMATION";
        try {
            clientSocket.getObjos().writeObject(KEY);
            clientSocket.getObjos().flush();
            clientSocket.getObjos().writeObject(QUERY);
            clientSocket.getObjos().flush();
            personInformation = (ArrayList<String>) clientSocket.getObjis().readObject();
        } catch (IOException e) {
            throw new WrongConnectionException("Stream haven't opened", e);
        } catch (ClassNotFoundException e) {
            throw new WrongConnectionException("Object haven't read from Stream", e);
        }
        return personInformation;
    }

    List<String> sessionRequest() throws WrongConnectionException {
        List<String> sessionList;
        final String KEY = "SESSION";
        try {
            clientSocket.getObjos().writeObject(KEY);
            clientSocket.getObjos().flush();
            sessionList = (ArrayList<String>) clientSocket.getObjis().readObject();
        } catch (IOException e) {
            throw new WrongConnectionException("Stream haven't opened", e);
        } catch (ClassNotFoundException e) {
            throw new WrongConnectionException("Object haven't read from Stream", e);
        }
        return sessionList;
    }
}