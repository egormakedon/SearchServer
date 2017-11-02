package by.makedon.client.controller;

import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.validator.SocketParamsValidator;

public class ClientController {
    private ClientSocketProcessor clientSocketProcessor;

    public ClientController(ClientSocketProcessor clientSocketProcessor) {
        this.clientSocketProcessor = clientSocketProcessor;
    }

    public void connect(String ip, String port) throws WrongConnectionException {
        SocketParamsValidator validator = new SocketParamsValidator();
        if (!validator.validationIp(ip)) {
            throw new WrongConnectionException("Invalid ip: " + ip);
        }
        if (!validator.validationPort(port)) {
            throw new WrongConnectionException("Invalid port: " + port);
        }
        if (clientSocketProcessor.isConnection()) {
            throw new WrongConnectionException("Tried to set connection when you have already connected");
        }

        clientSocketProcessor.createClientSocket(ip, Integer.parseInt(port));
    }

    public boolean disconnect() {
        return clientSocketProcessor.closeClientSocket();
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
