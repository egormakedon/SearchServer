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
    private Timer timer;
    static Logger logger = LogManager.getLogger(SearchServer.class);

    {
        PORT = 9000;
        socketStore = SocketStore.getInstance();
    }

    class ClearSocketStoreTimer extends TimerTask {
        @Override
        public void run() {
            SocketStoreManager socketStoreManager = new SocketStoreManager();
            socketStoreManager.clearStore(socketStore);
        }
    }

    @Override
    public void run() {
        if (isServerRun) {
            logger.log(Level.INFO,"searchserver has already run");
            return;
        }

        logger.log(Level.INFO, "searchserver was run");
        isServerRun = true;

        final long DELAY = 300_000;
        timer = new Timer();
        timer.schedule(new ClearSocketStoreTimer(), DELAY);

        try {
            createServerSocket();
            createClientSocket();
        } catch (ServerException e) {
            logger.log(Level.ERROR, e);
        } finally {
            try {
                clearSocketStore();
                closeServerSocket();
                timer.cancel();
            } catch (ServerException e) {
                logger.log(Level.ERROR, e);
            }
        }
    }

    public void stopServer() {
        if (isServerRun) {
            isServerRun = false;
            logger.log(Level.INFO, "searchserver was stopped");
        } else {
            logger.log(Level.INFO,"searchserver has already stopped");
        }
    }

    private void createServerSocket() throws ServerException {
        try {
            ss = new ServerSocket(PORT);
            logger.log(Level.INFO, "created new ServerSocket");
        } catch (IOException e) {
            throw new ServerException("ServerSocket io exception", e);
        }
    }

    private void createClientSocket() throws ServerException {
        try {
            while (isServerRun) {
                Socket socket = ss.accept();
                socketStore.addSocket(socket);
                logger.log(Level.INFO, "new client " + socket.getInetAddress() + " connected");
                new Thread(new SocketProcessor(socket)).start();
            }
        } catch (IOException e) {
            throw new ServerException("Socket io exception", e);
        }
    }

    private void clearSocketStore() throws ServerException {
        SocketStoreManager socketStoreManager = new SocketStoreManager();
        socketStoreManager.closeSockets(socketStore);
        socketStoreManager.clearStore(socketStore);
    }

    private void closeServerSocket() throws ServerException {
        try {
            if (ss != null) {
                ss.close();
            }
        } catch (IOException e) {
            throw new ServerException("ServerSocket io exception", e);
        }
    }
}