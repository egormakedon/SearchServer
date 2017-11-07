package by.makedon.server.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientSession {
    private List<String[]> sessionList;

    public ClientSession() {
        sessionList = new ArrayList<String[]>();
    }

    public void add(String message) {
        String[] action = {
                new Date().toString(), message
        };
        sessionList.add(action);
    }

    public List<String[]> getSessionList() {
        return sessionList;
    }
}