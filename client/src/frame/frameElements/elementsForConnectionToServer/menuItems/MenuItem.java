package frame.frameElements.elementsForConnectionToServer.menuItems;

import javax.swing.*;

public class MenuItem {
    protected JMenuItem menuItem = new JMenuItem();

    protected void setMenuItem(String NAME) {
        menuItem.setText(NAME);
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }
}