package by.makedon.client.view.menuitem;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.dialog.ConnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionMenuItem {
    private JMenuItem menuItem;
    private ClientController clientController;

    public ConnectionMenuItem(ClientController clientController) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Connection to server..." + "</html>";
        menuItem = new JMenuItem(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        addDialog();
    }

    public JMenuItem getConnectionMenuItem() {
        return menuItem;
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Connection to server...";
                ConnectionDialog connectionDialog = new ConnectionDialog(DIALOG_TITLE, clientController);
                connectionDialog.set();
                connectionDialog.show();
            }
        });
    }
}
