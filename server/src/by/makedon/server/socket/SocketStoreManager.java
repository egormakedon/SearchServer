package by.makedon.server.socket;

import by.makedon.server.exception.ServerException;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class SocketStoreManager {
    public void closeSockets(SocketStore socketStore) throws ServerException {
        List<Socket> socketList = socketStore.getSocketList();
        for (Socket socket : socketList) {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new ServerException("Socket io exception", e);
                }
            }
        }
    }

    public void clearStore(SocketStore socketStore) {
        List<Socket> socketList = socketStore.getSocketList();
        for (Socket socket : socketList) {
            if (socket == null || socket.isClosed()) {
                socketList.remove(socket);
            }
        }
    }
}