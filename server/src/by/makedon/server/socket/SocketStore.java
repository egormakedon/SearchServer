package by.makedon.server.socket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketStore {
    private List<Socket> socketList = new ArrayList<Socket>();

    private SocketStore() {}

    private static class SingletonHolder {
        private final static SocketStore INSTANCE = new SocketStore();
    }

    public static SocketStore getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addSocket(Socket socket) {
        socketList.add(socket);
    }

    List<Socket> getSocketList() {
        return socketList;
    }
}