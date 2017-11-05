package by.makedon.client.main;

import by.makedon.client.controller.ClientSocketProcessor;
import by.makedon.client.controller.ClientController;
import by.makedon.client.model.PersonList;
import by.makedon.client.socket.ClientSocket;
import by.makedon.client.view.frame.MainFrame;
import by.makedon.client.socket.ClientSocketInfo;

public class Main {
    public static void main(String[] args) {
        PersonList personList = PersonList.getInstance();

        ClientSocket clientSocket = new ClientSocket();
        ClientSocketInfo clientSocketInfo = new ClientSocketInfo();
        ClientSocketProcessor clientSocketProcessor = new ClientSocketProcessor(clientSocket, clientSocketInfo);
        ClientController clientController = new ClientController(clientSocketProcessor, personList);

        MainFrame mainFrame = new MainFrame(clientController);
        mainFrame.set();
        mainFrame.show();
    }
}