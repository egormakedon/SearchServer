package by.makedon.server.view;

import by.makedon.server.searchserver.SearchServer;

import java.awt.*;
import java.awt.event.ActionEvent;

public class StopButton extends Button {
    private SearchServer searchServer;

    public StopButton(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            searchServer.stopServer();
    }

    @Override
    public void setSize(int W, int H) {
        super.getButton().setSize(new Dimension(W, H));
        super.getButton().setPreferredSize(new Dimension(W, H));
    }

    public void setSearchServer(SearchServer searchServer) {
        this.searchServer = searchServer;
    }
}