package by.makedon.server.session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientSession {
    private List<String> sessionList;

    public ClientSession() {
        sessionList = new ArrayList<String>();
    }

    public void add(String message) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_hh:mm:ss");
        final String SESSION = dateFormat.format(date) + " " + message;
        sessionList.add(SESSION);
    }

    public List<String> getSessionList() {
        return sessionList;
    }
}