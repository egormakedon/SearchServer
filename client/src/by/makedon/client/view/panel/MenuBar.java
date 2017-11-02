package by.makedon.client.view.panel;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.menu.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuBar {
    private JMenuBar menuBar;
    private ClientController clientController;

    public MenuBar(ClientController clientController) {
        menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        this.clientController = clientController;
    }

    public void set() {
        setSize();
        addMenu();
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private void setSize() {
        final int WIDTH = 0;
        final int HEIGHT = 30;
        menuBar.setSize(new Dimension(WIDTH, HEIGHT));
        menuBar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void addMenu() {
        Menu menu = new Menu(clientController);
        menu.set();
        menuBar.add(menu.getMenu());
    }
}
