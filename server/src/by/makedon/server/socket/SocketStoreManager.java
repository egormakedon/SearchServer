package by.makedon.server.socket;

import by.makedon.server.exception.ServerException;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketStoreManager {
    public void closeAllSockets(SocketStore socketStore) throws ServerException {
        List<Socket> socketList = socketStore.getSocketList();
        for (Socket socket : socketList) {
            if (!socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new ServerException("SocketException", e);
                }
            }
        }
    }

    public void clearStore(SocketStore socketStore) {
        List<Socket> socketList = socketStore.getSocketList();
        List<Integer> socketIndexList = new ArrayList<Integer>();
        for (int socketIndex = 0; socketIndex < socketList.size(); socketIndex++) {
            Socket socket = socketList.get(socketIndex);
            if (socket.isClosed()) {
                socketIndexList.add(socketIndex);
            }
        }
        if (!socketIndexList.isEmpty()) {
            for (int socketIndex : socketIndexList) {
                socketList.remove(socketIndex);
            }
        }
    }
}