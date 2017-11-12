package by.makedon.server.main;

import by.makedon.server.searchserver.SearchServerState;
import by.makedon.server.view.frame.Frame;

public class Main {
    public static void main(String[] args) {
        SearchServerState searchServerState = new SearchServerState();
        Frame frame = new Frame(searchServerState);
        frame.setFrame();
        frame.show();
    }
}