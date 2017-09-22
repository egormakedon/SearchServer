package frame.frameElements.elementsForConnectionToServer;

import javax.swing.*;

public class CheckMenuItem {
    private JMenuItem checkMenuItem = new JMenuItem();

    public CheckMenuItem() {
        setCheckMenuItem();
    }

    private void setCheckMenuItem() {
        final String NAME = "<html><font style=’italic’ size = 4>Check connection status...</html>";
        checkMenuItem.setText(NAME);
    }

    public JMenuItem getCheckMenuItem() {
        return checkMenuItem;
    }
}
