package by.makedon.server.searchserver;

import by.makedon.server.exception.ServerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchServerState {
    private SearchServer searchServer;
    private boolean state;
    private Thread searchServerThread;
    static Logger logger = LogManager.getLogger(SearchServerState.class);

    public SearchServerState() {
        searchServer = new SearchServer();
    }

    public boolean getState() {
        return state;
    }

    public void startSearchServer() {
        state = true;
        searchServerThread = new Thread(searchServer);
        searchServerThread.start();
        logger.log(Level.INFO, "SearchServer has started");
    }

    public void stopSearchServer() {
        state = false;
        searchServerThread.interrupt();
        searchServer.stopTimer();
        closeAllSockets();
        searchServer.clearSocketStore();
        closeServerSocket();
        logger.log(Level.INFO, "SearchServer has stoped");
    }

    private void closeAllSockets() {
        try {
            searchServer.closeAllSockets();
        } catch (ServerException e) {
            logger.log(Level.ERROR, e);
        }
    }

    private void closeServerSocket() {
        try {
            searchServer.closeServerSocket();
        } catch (ServerException e) {
            logger.log(Level.ERROR, e);
        }
    }
}