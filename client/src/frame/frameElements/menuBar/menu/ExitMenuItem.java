package frame.frameElements.menuBar.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuItem {
    private JMenuItem exitMenuItem = new JMenuItem();

    public ExitMenuItem() {
        setExitMenuItem();
        addExitFunctionToExitMenuItem();
    }

    private void setExitMenuItem() {
        final String NAME = "<html><font style=’italic’ size = 4>Exit...</html>";
        exitMenuItem.setText(NAME);
    }

    private void addExitFunctionToExitMenuItem() {
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
