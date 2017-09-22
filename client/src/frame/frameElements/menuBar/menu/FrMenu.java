package frame.frameElements.menuBar.menu;

import frame.frameElements.elementsForConnectionToServer.menuItems.CheckMenuItem;
import frame.frameElements.elementsForConnectionToServer.menuItems.ConnectionMenuItem;
import frame.frameElements.elementsForConnectionToServer.menuItems.DisconnectionMenuItem;

import javax.swing.*;

public class FrMenu {
    private JMenu menu = new JMenu();

    public FrMenu() {
        setMenu();
        addConnectionMenuItemToMenu();
        addDisconnectionMenuItemToMenu();
        addCheckMenuItemToMenu();
        menu.addSeparator();
        addExitMenuItemToMenu();
    }

    private void setMenu() {
        final String NAME = "<html><font style=’italic’ size = 4>Menu</html>";
        menu.setText(NAME);
    }

    private void addConnectionMenuItemToMenu() {
        final String NAME = "Connection to server...";
        ConnectionMenuItem menuItem = new ConnectionMenuItem(NAME);
        JMenuItem connectionMenuItem = menuItem.getConnectionMenuItem();
        menu.add(connectionMenuItem);
    }

    private void addDisconnectionMenuItemToMenu() {
        final String NAME = "Disconnection from server...";
        DisconnectionMenuItem menuItem = new DisconnectionMenuItem(NAME);
        JMenuItem disconnectionMenuItem = menuItem.getDisconnectionMenuItem();
        menu.add(disconnectionMenuItem);
    }

    private void addCheckMenuItemToMenu() {
        final String NAME = "Check connection status...";
        CheckMenuItem menuItem = new CheckMenuItem(NAME);
        JMenuItem checkMenuItem = menuItem.getCheckMenuItem();
        menu.add(checkMenuItem);
    }

    private void addExitMenuItemToMenu() {
        ExitMenuItem menuItem = new ExitMenuItem();
        JMenuItem exitMenuItem = menuItem.getExitMenuItem();
        menu.add(exitMenuItem);
    }

    public JMenu getMenu() {
        return menu;
    }
}
