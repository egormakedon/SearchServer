package clientModel;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public boolean setClientSocket(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
