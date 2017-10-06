package main;

import clientController.Controller;
import clientModel.Client;
import frame.MainFrame;
import clientModel.ServerData;

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