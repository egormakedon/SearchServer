package by.makedon.server.view.frame;

import by.makedon.server.searchserver.SearchServerState;
import by.makedon.server.view.button.RunButton;
import by.makedon.server.view.button.StopButton;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame frame;
    private RunButton runButton;
    private StopButton stopButton;
    private SearchServerState searchServerState;

    {
        runButton = new RunButton("Run");
        stopButton = new StopButton("Stop");

        final int W = 100;
        final int H = 50;
        runButton.setSize(W, H);
        stopButton.setSize(W, H);
    }

    public Frame(SearchServerState searchServerState) {
        this.searchServerState = searchServerState;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFrame() {
        FrameCreator frameCreator = new FrameCreator();

        final String FRAME_TITLE = "Server";
        frameCreator.setTittle(frame, FRAME_TITLE);

        final int W = 500;
        final int H = 500;
        frameCreator.setSize(frame, W, H);

        frameCreator.setLayout(frame, new GridBagLayout());

        setSearchServerToButton();
        setListenerToButton();
        frameCreator.setButton(frame, runButton.getButton());
        frameCreator.setButton(frame, stopButton.getButton());
    }

    public void show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setSearchServerToButton() {
        runButton.setSearchServerState(searchServerState);
        stopButton.setSearchServerState(searchServerState);
    }

    private void setListenerToButton() {
        runButton.getButton().addActionListener(runButton);
        stopButton.getButton().addActionListener(stopButton);
    }
}
