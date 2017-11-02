package by.makedon.client.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuItem {
    private JMenuItem exitMenuItem = new JMenuItem();

    public void set() {
        setTitle();
        addListener();
    }

    private void setTitle() {
        final String TITLE = "<html><font style=’italic’ size = 4>Exit...</html>";
        exitMenuItem.setText(TITLE);
    }

    private void addListener() {
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int STATUS = 0;
                System.exit(STATUS);
            }
        });
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }
}
