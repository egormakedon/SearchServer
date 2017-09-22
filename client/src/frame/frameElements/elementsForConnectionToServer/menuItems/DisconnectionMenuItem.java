package frame.frameElements.elementsForConnectionToServer.menuItems;

import frame.frameElements.elementsForConnectionToServer.dialog.DisconnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionMenuItem extends MenuItem {

    public DisconnectionMenuItem(String NAME) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + NAME + "</html>";
        setMenuItem(TITLE);
        addDisconnectionDialogToMenuItem();
    }

    private void addDisconnectionDialogToMenuItem() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Disconnection from server...";
                DisconnectionDialog disconnectionDialog = new DisconnectionDialog(DIALOG_TITLE);
                disconnectionDialog.show();
            }
        });
    }

    public JMenuItem getDisconnectionMenuItem() {
        return menuItem;
    }
}
