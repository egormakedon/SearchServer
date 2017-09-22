package frame.frameElements.elementsForConnectionToServer;

import javax.swing.*;

public class ConnectionMenuItem {
    private JMenuItem connectionMenuItem = new JMenuItem();

    public ConnectionMenuItem() {
        setConnectionMenuItem();
    }

    private void setConnectionMenuItem() {
        final String NAME = "<html><font style=’italic’ size = 4>Connection to server...</html>";
        connectionMenuItem.setText(NAME);
    }

    public JMenuItem getConnectionMenuItem() {
        return connectionMenuItem;
    }
}
