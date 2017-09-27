package sessionModel;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;

public class SessionModel {
    private final File SESSION_DIR;
    private ArrayList<Socket> socketList = new ArrayList<>();

    public SessionModel() {
        SESSION_DIR = new File(System.getProperty("user.dir") + "/session");
        createSessionDir();
    }

    private void createSessionDir() {
        if (SESSION_DIR.exists()) {
            for (File f : SESSION_DIR.listFiles()) {
                f.delete();
            }
        } else {
            SESSION_DIR.mkdir();
        }
    }

    public boolean checkSocketExistInList(Socket socket) {
        for (Socket s : socketList) {
            if (s == socket) return true;
        }
        return false;
    }

    public void addSocketToList(Socket socket) {
        final int SOCKET_NUM = socketList.size();
        socketList.add(socket);
        createFileForSocket(SOCKET_NUM, socket);
    }

    private void createFileForSocket(int SOCKET_NUM, Socket socket) {
        
    }
}
