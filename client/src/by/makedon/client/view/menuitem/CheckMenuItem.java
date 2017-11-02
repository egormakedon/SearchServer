package by.makedon.client.view.menuitem;

import by.makedon.client.controller.Controller;
import by.makedon.client.view.dialog.CheckDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckMenuItem {
    private JMenuItem menuItem = new JMenuItem();
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

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
                checkDialog.setConnInfPanel(controller.addInfToCheckDialog());
                checkDialog.show();
            }
        });
    }

    public JMenuItem getCheckMenuItem() {
        return menuItem;
    }
}
