package by.makedon.server.searchserver;

import by.makedon.server.exception.ServerException;
import by.makedon.server.controller.SocketProcessor;
import by.makedon.server.socket.SocketStore;
import by.makedon.server.socket.SocketStoreManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SearchServer implements Runnable {
    private final int PORT;
    private ServerSocket ss;
    private boolean isServerRun;
    private SocketStore socketStore;
    static Logger logger = LogManager.getLogger(SearchServer.class);

    public SearchServer() {
        PORT = 9000;
        socketStore = SocketStore.getInstance();
    }

//    class ClearSocketStoreTimer extends TimerTask {
//        @Override
//        public void run() {
//            SocketStoreManager socketStoreManager = new SocketStoreManager();
//            socketStoreManager.clearStore(socketStore);
//        }
//    }

    @Override
    public void run() {
        if (isServerRun) {
            logger.log(Level.INFO,"SearchServer has already run");
            return;
        }

        isServerRun = true;
        logger.log(Level.INFO, "SearchServer was ran");

//        final long DELAY = 60_000;
//        Timer timer = new Timer();
//        timer.schedule(new ClearSocketStoreTimer(), DELAY);

        try {
            ss = new ServerSocket(PORT);
            logger.log(Level.INFO, "ServerSocket was created");
        } catch (IOException e) {
            logger.log(Level.ERROR,"ServerSocket io exception", e);
            isServerRun = false;
            return;
        }

        try {
            while (isServerRun) {
                try {
                    Socket socket = ss.accept();
                    logger.log(Level.INFO, "ClientSocket " + socket.getInetAddress() + " " + socket.getPort() + " was connected");
                    socketStore.addSocket(socket);
                    new Thread(new SocketProcessor(socket)).start();
                } catch (IOException e) {
                    logger.log(Level.WARN, e);
                }
            }
        } finally {
            try {
                clearSocketStore();
            } catch (ServerException e) {
                logger.log(Level.ERROR, e);
            }
            try {
                closeServerSocket();
            } catch (ServerException e) {
                logger.log(Level.ERROR, e);
            }
        }
    }

    public void stopServer() {
        if (isServerRun) {
            isServerRun = false;
            logger.log(Level.INFO, "SearchServer was stopped");
        } else {
            logger.log(Level.INFO,"SearchServer has already stopped");
        }
    }

    private void clearSocketStore() throws ServerException {
        SocketStoreManager socketStoreManager = new SocketStoreManager();
        socketStoreManager.closeSockets(socketStore);
        logger.log(Level.INFO, "All ClientSockets was closed");
        socketStoreManager.clearStore(socketStore);
        logger.log(Level.INFO, "SocketStore was cleared");
    }

    private void closeServerSocket() throws ServerException {
        try {
            if (!ss.isClosed()) {
                ss.close();
                logger.log(Level.INFO, "ServerSocket was closed");
            }
        } catch (IOException e) {
            throw new ServerException("ServerSocket io exception", e);
        }
    }
}