package clientController;

import clientModel.Client;
import clientModel.ServerData;

import javax.swing.*;

public class Controller {
    private ServerData serverData;
    private Client client;

    public void setServerData(ServerData serverData) {
        this.serverData = serverData;
    }
    public void setClient(Client client) { this.client = client; }

    public void connect(String ip, String port) {
        if (isConnection()) {
            return;
        }
        else {
            if (!checkPort(port)) {
                JOptionPane.showMessageDialog(null, "Exception. Check log.");
                return;
            }
            serverData.setIp(ip);
            serverData.setPort(port);
            connect();
        }
    }

    private void connect() {
        String ip = serverData.getIp();
        int port = Integer.parseInt(serverData.getPort());

        if (!client.setClientSocket(ip, port)) {
            JOptionPane.showMessageDialog(null, "Exception. Check log.");
        } else {
            serverData.setIsConnectionTrue();
        }
    }

    private boolean isConnection() {
        return serverData.isConnection();
    }

    private boolean checkPort(String port) {
        try {
            Integer.parseInt(port);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
