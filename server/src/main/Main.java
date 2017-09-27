package main;

import server.SearchServer;
import sessionModel.SessionModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Throwable {
//        SearchServer searchServer = new SearchServer();
//
//        SessionModel sessionModel = new SessionModel();
//        searchServer.setSessionModel(sessionModel);
//
//        searchServer.runServer();

        File SESSION_DIR = new File(System.getProperty("user.dir") + "/session/" + "1.txt");
        SESSION_DIR.createNewFile();
    }
}