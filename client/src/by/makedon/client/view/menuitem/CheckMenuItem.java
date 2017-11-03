package by.makedon.client.view.menuitem;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.dialog.CheckDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckMenuItem {
    private JMenuItem menuItem;
    private ClientController clientController;

    public CheckMenuItem(ClientController clientController) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Check connection status..." + "</html>";
        menuItem = new JMenuItem(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        addDialog();
    }

    public JMenuItem getCheckMenuItem() {
        return menuItem;
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Check connection status...";
                CheckDialog checkDialog = new CheckDialog(DIALOG_TITLE, clientController);
                checkDialog.set();
                checkDialog.show();
            }
        });
    }
}