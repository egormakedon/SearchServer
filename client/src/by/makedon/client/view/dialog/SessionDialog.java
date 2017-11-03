package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;

import java.awt.*;

class SessionDialog extends Dialog {
    private ClientController clientController;

    SessionDialog(String TITLE, ClientController clientController) {
        super(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        setSize();
        setDialog();
    }

    void setSize() {
        final int WIDTH = 400;
        final int HEIGHT = 600;
        dialog.setSize(new Dimension(WIDTH, HEIGHT));
        dialog.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        dialog.setResizable(false);
    }
}
