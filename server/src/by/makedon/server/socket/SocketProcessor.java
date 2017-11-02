package by.makedon.server.socket;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketProcessor implements Runnable {
    private Socket socket;
    private InputStream is;
    private boolean isSocketRun;
    static Logger logger = LogManager.getLogger(SocketProcessor.class);

    public SocketProcessor(Socket socket) {
        this.socket = socket;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            logger.log(Level.WARN, e);
        }
        isSocketRun = true;
    }

    @Override
    public void run() {
        while(isSocketRun) {

        }
    }
}
