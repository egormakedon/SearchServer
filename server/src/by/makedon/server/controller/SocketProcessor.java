package by.makedon.server.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
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
        logger.log(Level.INFO, "Client " + socket.getInetAddress() + " Thread have run");

        final int DELAY = 1_000;
        Timer timer = new Timer();
        timer.schedule(new CloseSocketTimer(), DELAY);

        final String PERSON_INFORMATION_KEY = "PERSONINFORMATION";
        final String SESSION_KEY = "SESSION";

        while (isSocketRun) {
            ObjectInputStream objis = null;
            ObjectOutputStream objos = null;
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                objis = new ObjectInputStream(is);
                objos = new ObjectOutputStream(os);

                final String KEY = (String) objis.readObject();
                switch (KEY) {
                    case PERSON_INFORMATION_KEY:
                        final String QUERY = (String) objis.readObject();
                        Controller controller = new Controller();
                        objos.flush();
                        objos.writeObject(controller.findPersonInformation(QUERY));
                        objos.flush();
                        break;
                    case SESSION_KEY:
                        /////////
                        break;
                }
            } catch (ClassNotFoundException | IOException e) {
                logger.log(Level.WARN, e);
            } finally {
                if (objis != null) {
                    try {
                        objis.close();
                    } catch (IOException e) {
                        logger.log(Level.WARN, e);
                    }
                }
                if (objos != null) {
                    try {
                        objos.close();
                    } catch (IOException e) {
                        logger.log(Level.WARN, e);
                    }
                }
            }
        }
        timer.cancel();
        logger.log(Level.INFO, "Client " + socket.getInetAddress() + " Thread have stopped");
        if (socket != null && !socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                logger.log(Level.WARN, e);
            }
        }
        logger.log(Level.INFO, "ClientSocket " + socket.getInetAddress() + " have closed");
    }
}