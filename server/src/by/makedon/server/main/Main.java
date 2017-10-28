package by.makedon.server.main;

import by.makedon.server.searchserver.SearchServer;
import by.makedon.server.view.frame.Frame;

public class Main {
    public static void main(String[] args) {
        SearchServer searchServer = new SearchServer();

        Frame frame = new Frame(searchServer);
        frame.setFrame();
        frame.show();
    }
}