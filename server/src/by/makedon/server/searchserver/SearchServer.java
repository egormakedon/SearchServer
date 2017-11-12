package by.makedon.server.searchserver;

import by.makedon.server.database.BookOfReferenceDB;
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
import java.util.concurrent.TimeUnit;

public class SearchServer implements Runnable {
    private final int PORT;
    private ServerSocket ss;
    private SocketStore socketStore;
    private BookOfReferenceDB db;
    private ClearSocketStoreTimer timer;
    static Logger logger = LogManager.getLogger(SearchServer.class);

    SearchServer() {
        PORT = 7777;
        socketStore = SocketStore.getInstance();
        db = new BookOfReferenceDB();
    }

    class ClearSocketStoreTimer extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    TimeUnit.MINUTES.sleep(1);
                    clearSocketStore();
                } catch (InterruptedException e) {
                    logger.log(Level.WARN, "ClearSocketStoreTimer interrupted");
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        timer = new ClearSocketStoreTimer();
        timer.start();

        try {
            ss = new ServerSocket(PORT);
            logger.log(Level.INFO, "ServerSocket has opened");
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new RuntimeException();
        }

        while (true) {
            try {
                Socket socket = ss.accept();
                logger.log(Level.INFO, "Socket " + socket.getInetAddress() + " " + socket.getPort() + " has connected");
                socketStore.addSocket(socket);
                SocketProcessor socketProcessor = new SocketProcessor(socket, db);
                new Thread(socketProcessor).start();
            } catch (IOException e) {
                if (ss.isClosed()) {
                    break;
                } else {
                    logger.log(Level.ERROR, e);
                }
            }
        }
    }

    void closeAllSockets() throws ServerException {
        SocketStoreManager socketStoreManager = new SocketStoreManager();
        socketStoreManager.closeAllSockets(socketStore);
    }

    void clearSocketStore() {
        SocketStoreManager socketStoreManager = new SocketStoreManager();
        socketStoreManager.clearStore(socketStore);
    }

    void closeServerSocket() throws ServerException {
        if (ss != null) {
            try {
                ss.close();
                logger.log(Level.INFO, "ServerSocket has closed");
            } catch(IOException e) {
                throw new ServerException("ServerSocketException", e);
            }
        }
    }

    void stopTimer() {
        timer.interrupt();
    }
}