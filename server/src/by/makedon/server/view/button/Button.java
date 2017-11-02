package by.makedon.server.view.button;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract class Button implements ActionListener {
    private JButton button;

    Button(String title) {
        button = new JButton(title);
    }

    public abstract void setSize(final int W, final int H);

    public JButton getButton() {
        return button;
    }
}
