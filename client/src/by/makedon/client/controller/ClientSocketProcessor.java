package by.makedon.client.controller;

import by.makedon.client.socket.ClientSocket;
import by.makedon.client.socket.ClientSocketInfo;

public class ClientSocketProcessor {
    private ClientSocket clientSocket;
    private ClientSocketInfo clientSocketInfo;

    public ClientSocketProcessor(ClientSocket clientSocket, ClientSocketInfo clientSocketInfo) {
        this.clientSocket = clientSocket;
        this.clientSocketInfo = clientSocketInfo;
    }


}
