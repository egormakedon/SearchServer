package frame.frameElements.elementsForConnectionToServer;

import javax.swing.*;

public class DisconnectionMenuItem {
    private JMenuItem disconnectionMenuItem = new JMenuItem();

    public DisconnectionMenuItem() {
        setDisconnectionMenuItem();
    }

    private void setDisconnectionMenuItem() {
        final String NAME = "<html><font style=’italic’ size = 4>Disconnection from server...</html>";
        disconnectionMenuItem.setText(NAME);
    }

    public JMenuItem getDisconnectionMenuItem() {
        return disconnectionMenuItem;
    }
}
