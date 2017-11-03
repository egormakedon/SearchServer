package by.makedon.client.controller;

import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.validator.SocketParamsValidator;

import java.util.List;

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

    public List<String> getConnectionInfo() {
        List<String> connectionInfoList = clientSocketProcessor.getConnectionInfo();
        if (clientSocketProcessor.isConnection()) {
            final String TRUE = "TRUE";
            connectionInfoList.add(TRUE);
        } else {
            final String FALSE = "FALSE";
            connectionInfoList.add(FALSE);
        }
        return connectionInfoList;
    }
}
