package by.makedon.server.socket;

import by.makedon.server.exception.ServerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketStoreManager {
    static Logger logger = LogManager.getLogger(SocketStoreManager.class);

    public void closeSockets(SocketStore socketStore) throws ServerException {
        List<Socket> socketList = socketStore.getSocketList();
        for (Socket socket : socketList) {
            if (!socket.isClosed()) {
                try {
                    socket.close();
                    logger.log(Level.INFO,"ClientSocket " + socket.getInetAddress() + " " + socket.getPort() + " was closed");
                } catch (IOException e) {
                    throw new ServerException("ClientSocket io exception", e);
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
                logger.log(Level.INFO,"ClientSocket " + socketList.get(socketIndex).getInetAddress() + " " + socketList.get(socketIndex).getPort() + " was deleted from SocketStore");
                socketList.remove(socketIndex);
            }
        }
    }
}