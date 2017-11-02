package by.makedon.client.view.menuitem;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.dialog.DisconnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionMenuItem {
    private JMenuItem menuItem;
    private ClientController clientController;

    public DisconnectionMenuItem(ClientController clientController) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Disconnection from server..." + "</html>";
        menuItem = new JMenuItem(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        addDialog();
    }

    public JMenuItem getDisconnectionMenuItem() {
        return menuItem;
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Disconnection from server...";
                DisconnectionDialog disconnectionDialog = new DisconnectionDialog(DIALOG_TITLE, clientController);
                disconnectionDialog.set();
                disconnectionDialog.show();
            }
        });
    }
}
