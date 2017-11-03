package by.makedon.server.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SocketProcessor implements Runnable {
    private Socket socket;
    private boolean isSocketRun;
    static Logger logger = LogManager.getLogger(SocketProcessor.class);

    public SocketProcessor(Socket socket) {
        this.socket = socket;
        isSocketRun = true;
    }

    class CloseSocketTimer extends TimerTask {
        @Override
        public void run() {
            try {
                final int TIMEOUT = 500;
                if (socket != null && (socket.isClosed() || !socket.getInetAddress().isReachable(TIMEOUT))) {
                    isSocketRun = false;
                }
            } catch (IOException e) {
                logger.log(Level.WARN, e);
            }
        }
    }

    @Override
    public void run() {
        final int DELAY = 1_000;
        Timer timer = new Timer();
        timer.schedule(new CloseSocketTimer(), DELAY);
        InputStream is = null;

        try {
            is = socket.getInputStream();
            while (isSocketRun) {

            }
        } catch (IOException e) {
            logger.log(Level.WARN, e);
        } finally {
            timer.cancel();

            if (is != null) try {
                is.close();
            } catch (IOException e) {
                logger.log(Level.WARN, e);
            }

            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    logger.log(Level.WARN, e);
                }
            }
        }
    }
}