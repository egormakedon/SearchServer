package by.makedon.client.view.dialog;

import javax.swing.*;
import java.awt.*;

public class Dialog {
    JDialog dialog;

    Dialog(String TITLE) {
        dialog = new JDialog();
        dialog.setTitle(TITLE);
    }

    void setSize() {
        final int WIDTH = 600;
        final int HEIGHT = 300;
        dialog.setSize(new Dimension(WIDTH, HEIGHT));
        dialog.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        dialog.setResizable(false);
    }

    void setDialog() {
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
    }

    public void show() {
        dialog.setVisible(true);
    }
}