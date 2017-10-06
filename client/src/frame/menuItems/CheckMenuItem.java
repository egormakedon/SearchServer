package frame.menuItems;

import dialog.CheckDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckMenuItem {
    private JMenuItem menuItem = new JMenuItem();

    public void set() {
        setTitle();
    }

    private void setTitle() {
        final String TITLE = "<html><font style=’italic’ size = 4>" + "Check connection status..." + "</html>";
        menuItem.setText(TITLE);
        addDialog();
    }

    private void addDialog() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DIALOG_TITLE = "Check connection status...";
                CheckDialog checkDialog = new CheckDialog(DIALOG_TITLE);
                checkDialog.set();
                checkDialog.show();
            }
        });
    }

    public JMenuItem getCheckMenuItem() {
        return menuItem;
    }
}
