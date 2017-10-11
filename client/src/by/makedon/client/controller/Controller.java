package by.makedon.client.controller;

import by.makedon.client.model.Client;
import by.makedon.client.model.ServerData;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.validator.SocketParamsValidator;

public class Controller {
    private ServerData serverData;
    private Client client;
    public void setServerData(ServerData serverData) {
        this.serverData = serverData;
    }
    public void setClient(Client client) { this.client = client; }

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
        return serverData.isConnection();
    }
    private void createSocket(String ip, int port) throws WrongConnectionException {
        if (client.createSocket(ip, port)) {
            serverData.setIp(ip);
            serverData.setPort(port);
            serverData.setConnectionTrue();
        }
    }

    public boolean disconnect() {
        if (isConnection()) {
            serverData.setIpNull();
            serverData.setPortNull();
            serverData.setConnectionFalse();
            client.close();
            return true;
        } else {
            return false;
        }
    }

    public String[] addInfToCheckDialog() {
        String[] strings = new String[3];
        final String RED = "255 0 0";
        final String GREEN = "0 255 0";
        if (serverData.isConnection()) {
            strings[0] = serverData.getIp();
            strings[1] = Integer.toString(serverData.getPort());
            strings[2] = GREEN;
        } else {
            strings[0] = "";
            strings[1] = "";
            strings[2] = RED;
        }
        return strings;
    }
}
