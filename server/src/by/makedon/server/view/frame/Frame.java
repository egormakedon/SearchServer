package by.makedon.server.view.frame;

import by.makedon.server.searchserver.SearchServer;
import by.makedon.server.view.RunButton;
import by.makedon.server.view.StopButton;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame frame;
    private RunButton runButton;
    private StopButton stopButton;
    private SearchServer searchServer;

    {
        runButton = new RunButton("Run");
        stopButton = new StopButton("Stop");

        final int W = 100;
        final int H = 50;
        runButton.setSize(W, H);
        stopButton.setSize(W, H);
    }

    public Frame(SearchServer searchServer) {
        this.searchServer = searchServer;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFrame() {
        FrameAction frameAction = new FrameAction();

        final String FRAME_TITLE = "Server";
        frameAction.setTittle(frame, FRAME_TITLE);

        final int W = 500;
        final int H = 500;
        frameAction.setSize(frame, W, H);

        frameAction.setLayout(frame, new GridBagLayout());

        setSearchServerToButton();
        setListenerToButton();
        frameAction.setButton(frame, runButton.getButton());
        frameAction.setButton(frame, stopButton.getButton());
    }

    private void setSearchServerToButton() {
        runButton.setSearchServer(searchServer);
        stopButton.setSearchServer(searchServer);
    }

    private void setListenerToButton() {
        runButton.getButton().addActionListener(runButton);
        stopButton.getButton().addActionListener(stopButton);
    }

    public void show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
