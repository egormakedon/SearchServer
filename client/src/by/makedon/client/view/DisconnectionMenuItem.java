package by.makedon.client.view;

import by.makedon.client.controller.Controller;
import by.makedon.client.dialog.DisconnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionMenuItem {
    private JMenuItem menuItem = new JMenuItem();
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void set() {
        setTitle();
        addDialog();
    }

    private void setTitle() {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Disconnection from server..." + "</html>";
        menuItem.setText(TITLE);
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Disconnection from server...";
                DisconnectionDialog disconnectionDialog = new DisconnectionDialog(DIALOG_TITLE);
                disconnectionDialog.setController(controller);
                disconnectionDialog.set();
                disconnectionDialog.show();
            }
        });
    }

    public JMenuItem getDisconnectionMenuItem() {
        return menuItem;
    }
}
