package frame.frameElements.elementsForConnectionToServer.menuItems;

import frame.frameElements.elementsForConnectionToServer.dialog.CheckDialog;
import frame.frameElements.elementsForConnectionToServer.dialog.ConnectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckMenuItem extends MenuItem {

    public CheckMenuItem(String NAME) {
        final String TITLE = "<html><font style=’italic’ size = 4>" + NAME + "</html>";
        setMenuItem(TITLE);
        addCheckDialogToMenuItem();
    }

    private void addCheckDialogToMenuItem() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Check connection status...";
                CheckDialog checkDialog = new CheckDialog(DIALOG_TITLE);
                checkDialog.show();
            }
        });
    }

    public JMenuItem getCheckMenuItem() {
        return menuItem;
    }
}
