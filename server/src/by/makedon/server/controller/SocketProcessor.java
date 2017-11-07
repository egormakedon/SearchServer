package by.makedon.server.controller;

import by.makedon.server.session.ClientSession;
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
    private ClientSession clientSession;
    static Logger logger = LogManager.getLogger(SocketProcessor.class);

    public SocketProcessor(Socket socket) {
        this.socket = socket;
        isSocketRun = true;
        clientSession = new ClientSession();
    }

//    class CloseSocketTimer extends TimerTask {
//        @Override
//        public void run() {
//            try {
//                final int TIMEOUT = 500;
//                if (socket != null && (socket.isClosed() || !socket.getInetAddress().isReachable(TIMEOUT))) {
//                    isSocketRun = false;
//                }
//            } catch (IOException e) {
//                logger.log(Level.WARN, e);
//            }
//        }
//    }

    @Override
    public void run() {
//        final int DELAY = 1_000;
//        Timer timer = new Timer();
//        timer.schedule(new CloseSocketTimer(), DELAY);
        clientSession.add("Connected to server");

        final String PERSON_INFORMATION_KEY = "PERSONINFORMATION";
        final String SESSION_KEY = "SESSION";

        ObjectInputStream objis = null;
        ObjectOutputStream objos = null;
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            objis = new ObjectInputStream(is);
            objos = new ObjectOutputStream(os);

            while (isSocketRun) {
                final String KEY = (String) objis.readObject();
                switch (KEY) {
                    case PERSON_INFORMATION_KEY:
                        clientSession.add("Information request");
                        final String QUERY = (String) objis.readObject();
                        Controller controller = new Controller();
                        objos.writeObject(controller.findPersonInformation(QUERY));
                        objos.flush();
                        break;
                    case SESSION_KEY:
                        clientSession.add("Session request");
                        objos.writeObject(clientSession.getSessionList());
                        objos.flush();
                        break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            isSocketRun = false;
            logger.log(Level.ERROR, e);
        } finally {
            if (objis != null) {
                try {
                    objis.close();
                } catch (IOException e) {
                    logger.log(Level.ERROR, e);
                }
            }
            if (objos != null) {
                try {
                    objos.close();
                } catch (IOException e) {
                    logger.log(Level.ERROR, e);
                }
            }
            if (!socket.isClosed()) {
                try {
                    socket.close();
                    logger.log(Level.INFO, "ClientSocket " + socket.getInetAddress() + " " + socket.getPort() + " have closed");
                } catch (IOException e) {
                    logger.log(Level.ERROR, e);
                }
            }
        }
    }
}