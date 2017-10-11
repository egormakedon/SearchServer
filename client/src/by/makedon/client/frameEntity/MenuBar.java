package by.makedon.client.frameEntity;

import javax.swing.*;
import java.awt.*;

public class MenuBar {
    private JMenuBar menuBar = new JMenuBar();

    public void set() {
        setMenuBarSize();
        setMenuBar();
    }

    private void setMenuBarSize() {
        final int WIDTH = 0;
        final int HEIGHT = 30;
        menuBar.setSize(new Dimension(WIDTH, HEIGHT));
        menuBar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setMenuBar() {
        menuBar.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
