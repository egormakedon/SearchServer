package by.makedon.client.view.menuitem;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.dialog.ConnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionMenuItem {
    private JMenuItem menuItem = new JMenuItem();
    private ClientController clientController;

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void set() {
        setTittle();
        addDialog();
    }

    private void setTittle() {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Connection to server..." + "</html>";
        menuItem.setText(TITLE);
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Connection to server...";
                ConnectionDialog connectionDialog = new ConnectionDialog(DIALOG_TITLE);
                connectionDialog.setClientController(clientController);
                connectionDialog.set();
                connectionDialog.show();
            }
        });
    }

    public JMenuItem getConnectionMenuItem() {
        return menuItem;
    }
}
