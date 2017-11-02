package by.makedon.client.main;

import by.makedon.client.controller.Controller;
import by.makedon.client.socket.ClientSocket;
import by.makedon.client.view.frame.MainFrame;
import by.makedon.client.socket.ClientSocketInfo;

public class Main {
    public static void main(String[] args) {
        ClientSocketInfo clientSocketInfo = new ClientSocketInfo();
        ClientSocket clientSocket = new ClientSocket();
        Controller controller = new Controller();

        controller.setClientSocketInfo(clientSocketInfo);
        controller.setClientSocket(clientSocket);

        MainFrame fr = new MainFrame();
        fr.setController(controller);
        fr.set();
        fr.show();
    }
}