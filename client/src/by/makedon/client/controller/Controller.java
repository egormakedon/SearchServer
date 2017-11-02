package by.makedon.client.controller;

import by.makedon.client.socket.ClientSocket;
import by.makedon.client.socket.ClientSocketInfo;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.validator.SocketParamsValidator;

public class Controller {
    private ClientSocketInfo clientSocketInfo;
    private ClientSocket clientSocket;
    public void setClientSocketInfo(ClientSocketInfo clientSocketInfo) {
        this.clientSocketInfo = clientSocketInfo;
    }
    public void setClientSocket(ClientSocket clientSocket) { this.clientSocket = clientSocket; }

    public void connect(String ip, String port) throws WrongConnectionException {
        if (isConnection()) {
            throw new WrongConnectionException("Tried to set connection when you have already connected");
        } else {
            SocketParamsValidator validator = new SocketParamsValidator();
            if (!validator.validationIp(ip)) {
                throw new WrongConnectionException("Invalid ip: " + ip);
            }
            if (!validator.validationPort(port)) {
                throw new WrongConnectionException("Invalid port: " + port);
            }

            createSocket(ip, Integer.parseInt(port));
        }
    }
    private boolean isConnection() {
        return clientSocketInfo.isConnection();
    }
    private void createSocket(String ip, int port) throws WrongConnectionException {
        if (clientSocket.createSocket(ip, port)) {
            clientSocketInfo.setIp(ip);
            clientSocketInfo.setPort(port);
            clientSocketInfo.setConnectionTrue();
        }
    }

    public boolean disconnect() {
        if (isConnection()) {
            clientSocketInfo.setIpNull();
            clientSocketInfo.setPortNull();
            clientSocketInfo.setConnectionFalse();
            clientSocket.close();
            return true;
        } else {
            return false;
        }
    }

    public String[] addInfToCheckDialog() {
        String[] strings = new String[3];
        final String RED = "255 0 0";
        final String GREEN = "0 255 0";
        if (clientSocketInfo.isConnection()) {
            strings[0] = clientSocketInfo.getIp();
            strings[1] = Integer.toString(clientSocketInfo.getPort());
            strings[2] = GREEN;
        } else {
            strings[0] = "";
            strings[1] = "";
            strings[2] = RED;
        }
        return strings;
    }
}
