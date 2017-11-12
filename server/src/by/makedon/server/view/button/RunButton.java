package by.makedon.server.view.button;

import by.makedon.server.searchserver.SearchServerState;

import java.awt.*;
import java.awt.event.ActionEvent;

public class RunButton extends Button {
    private SearchServerState searchServerState;

    public RunButton(String title) {
        super(title);
    }

    public void setSearchServerState(SearchServerState searchServerState) {
        this.searchServerState = searchServerState;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!searchServerState.getState()) {
            searchServerState.startSearchServer();
        }
    }

    @Override
    public void setSize(int W, int H) {
        super.getButton().setSize(new Dimension(W, H));
        super.getButton().setPreferredSize(new Dimension(W, H));
    }
}
