package frame.menuItems;

import dialog.DisconnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionMenuItem {
    private JMenuItem menuItem = new JMenuItem();

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
                disconnectionDialog.set();
                disconnectionDialog.show();
            }
        });
    }

    public JMenuItem getDisconnectionMenuItem() {
        return menuItem;
    }
}
