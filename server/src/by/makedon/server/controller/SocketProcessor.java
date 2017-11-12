package by.makedon.server.controller;

import by.makedon.server.database.BookOfReferenceDB;
import by.makedon.server.session.ClientSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketProcessor implements Runnable {
    private Socket socket;
    private BookOfReferenceDB db;
    private ClientSession clientSession;
    static Logger logger = LogManager.getLogger(SocketProcessor.class);

    public SocketProcessor(Socket socket, BookOfReferenceDB db) {
        this.socket = socket;
        this.db = db;
        clientSession = new ClientSession();
    }

    @Override
    public void run() {
        final String PERSON_INFORMATION_KEY = "PERSONINFORMATION";
        final String SESSION_KEY = "SESSION";
        final String CLIENT_TEST_CONNECTION_KEY = "TEST";

        ObjectInputStream objis = null;
        ObjectOutputStream objos = null;
        try {
            objis = new ObjectInputStream(socket.getInputStream());
            objos = new ObjectOutputStream(socket.getOutputStream());

            clientSession.add("Connected_to_server");
            while (true) {
                final String KEY = (String) objis.readObject();
                switch (KEY) {
                    case PERSON_INFORMATION_KEY:
                        clientSession.add("Information_request");
                        final String QUERY = (String) objis.readObject();
                        List<String> personInformation = db.findPersonInformation(QUERY);
                        objos.writeObject(personInformation);
                        objos.flush();
                        break;
                    case SESSION_KEY:
                        clientSession.add("Session_request");
                        List<String> session = new ArrayList<String>(clientSession.getSessionList());
                        objos.writeObject(session);
                        objos.flush();
                        break;
                    case CLIENT_TEST_CONNECTION_KEY:
                        final String SUCCESSFULLY = "SUCCESSFULLY";
                        objos.writeObject(SUCCESSFULLY);
                        objos.flush();
                        break;
                }
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
            if (socket != null) {
                try {
                    socket.close();
                    logger.log(Level.INFO, "Socket " + socket.getInetAddress() + " " + socket.getPort() + " has closed");
                } catch (IOException e) {
                    logger.log(Level.WARN, e);
                }
            }
        }
    }
}