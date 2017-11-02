package by.makedon.client.main;

import by.makedon.client.controller.Controller;
import by.makedon.client.model.Client;
import by.makedon.client.view.frame.MainFrame;
import by.makedon.client.model.ServerData;

public class Main {
    public static void main(String []arg) {
        ServerData serverData = new ServerData();
        Client client = new Client();
        Controller controller = new Controller();

        controller.setServerData(serverData);
        controller.setClient(client);

        MainFrame fr = new MainFrame();
        fr.setController(controller);
        fr.set();
        fr.show();
    }
}