package frame.frameElements.elementsForConnectionToServer.menuItems;

import frame.frameElements.elementsForConnectionToServer.dialog.ConnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionMenuItem extends MenuItem {

    public ConnectionMenuItem(String NAME) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + NAME + "</html>";
        setMenuItem(TITLE);
        addConnectionDialogToMenuItem();
    }

    private void addConnectionDialogToMenuItem() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Connection to server...";
                ConnectionDialog connectionDialog = new ConnectionDialog(DIALOG_TITLE);
                connectionDialog.show();
            }
        });
    }

    public JMenuItem getConnectionMenuItem() {
        return menuItem;
    }
}
