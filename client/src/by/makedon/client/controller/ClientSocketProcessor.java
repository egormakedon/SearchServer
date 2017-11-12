package by.makedon.client.controller;

import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.exception.WrongDataInputException;
import by.makedon.client.socket.ClientSocket;
import by.makedon.client.socket.ClientSocketInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSocketProcessor {
    private ClientSocket clientSocket;
    private ClientSocketInfo clientSocketInfo;

    public ClientSocketProcessor(ClientSocket clientSocket, ClientSocketInfo clientSocketInfo) {
        this.clientSocket = clientSocket;
        this.clientSocketInfo = clientSocketInfo;
    }

    boolean connectionState() throws WrongConnectionException {
        if (clientSocketInfo.isConnection()) {
            ObjectOutputStream objos = clientSocket.getObjos();
            ObjectInputStream objis = clientSocket.getObjis();
            final String TEST_CONNECTION = "TEST";
            try {
                objos.writeObject(TEST_CONNECTION);
                objos.flush();
                objis.readObject();
                return true;
            } catch (ClassNotFoundException | IOException e) {
                closeClientSocket();
                throw new WrongConnectionException("Have lost connection to server");
            }
        } else {
            return false;
        }
    }

    void closeClientSocket() {
        clientSocketInfo.setConnectionFalse();
        clientSocket.closeClientSocket();
    }

    void createClientSocket(String ip, int port) throws WrongConnectionException {
        if (clientSocket.createClientSocket(ip, port)) {
            clientSocketInfo.setIpPort(ip, port);
            clientSocketInfo.setConnectionTrue();
        }
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
            ObjectInputStream objis = clientSocket.getObjis();
            ObjectOutputStream objos = clientSocket.getObjos();
            objos.writeObject(KEY);
            objos.flush();
            objos.writeObject(QUERY);
            objos.flush();
            personInformation = (List<String>)objis.readObject();
        } catch (IOException e) {
            throw new WrongConnectionException("Stream haven't opened", e);
        } catch (ClassNotFoundException e) {
            throw new WrongConnectionException("Object haven't read from stream", e);
        }
        return personInformation;
    }

    List<String> sessionRequest() throws WrongConnectionException {
        List<String> sessionList;
        final String KEY = "SESSION";
        try {
            ObjectInputStream objis = clientSocket.getObjis();
            ObjectOutputStream objos = clientSocket.getObjos();
            objos.writeObject(KEY);
            objos.flush();
            sessionList = (List<String>)objis.readObject();
        } catch (IOException e) {
            throw new WrongConnectionException("Stream haven't opened", e);
        } catch (ClassNotFoundException e) {
            throw new WrongConnectionException("Object haven't read from stream", e);
        }
        return sessionList;
    }
}