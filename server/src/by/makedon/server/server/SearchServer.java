package by.makedon.server.server;

import by.makedon.server.exception.ServerException;
import by.makedon.server.socket.SocketProcessor;
import by.makedon.server.socket.SocketStore;
import by.makedon.server.socket.SocketStoreManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SearchServer {
    private final int PORT;
    private ServerSocket ss;
    private boolean isServerRun;
    private SocketStore socketStore;
    static Logger logger = LogManager.getLogger(SearchServer.class);

    {
        PORT = 9000;
        socketStore = SocketStore.getInstance();
    }

    public void runServer() throws ServerException {
        if (isServerRun) {
            logger.log(Level.INFO,"server has already run");
            return;
        }

        isServerRun = true;
        try {
            ss = new ServerSocket(PORT);
            logger.log(Level.INFO, "created new ServerSocket");
        } catch (IOException e) {
            throw new ServerException("ServerSocket io exception", e);
        }

        try {
            while (isServerRun) {
                Socket socket = ss.accept();
                socketStore.addSocket(socket);
                logger.log(Level.INFO, "new client " + socket.getInetAddress() + " connected");
                new Thread(new SocketProcessor(socket)).run();
            }
        } catch (IOException e) {
            throw new ServerException("Socket io exception", e);
        }
    }

    public void stopServer() throws ServerException {
        if (!isServerRun) {
            logger.log(Level.INFO,"server has already stopped");
            return;
        }
        isServerRun = false;

        SocketStoreManager socketStoreManager = new SocketStoreManager();
        socketStoreManager.closeSockets(socketStore);
        socketStoreManager.clearStore(socketStore);

        try {
            ss.close();
            ss = null;
        } catch (IOException e) {
            throw new ServerException("ServerSocket io exception", e);
        }
    }
}