package by.makedon.server.view;

import by.makedon.server.exception.ServerException;
import by.makedon.server.searchserver.SearchServer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.ActionEvent;

public class StopButton extends Button {
    private SearchServer searchServer;
    static Logger logger = LogManager.getLogger(StopButton.class);

    public StopButton(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            searchServer.stopServer();
        } catch (ServerException e1) {
            logger.log(Level.ERROR, e1);
        }
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