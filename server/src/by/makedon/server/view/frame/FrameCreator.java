package by.makedon.server.view.frame;

import javax.swing.*;
import java.awt.*;

class FrameCreator {
    void setTittle(JFrame frame, String title) {
        frame.setTitle(title);
    }

    void setSize(JFrame frame, int w, int h) {
        frame.setSize(new Dimension(w, h));
        frame.setResizable(false);
    }

    void setLayout(JFrame frame, LayoutManager layout) {
        frame.setLayout(layout);
    }

    void setButton(JFrame frame, JButton button) {
        frame.add(button);
    }
}
