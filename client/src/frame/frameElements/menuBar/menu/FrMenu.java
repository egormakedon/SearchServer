package frame.frameElements.menuBar.menu;

import frame.frameElements.elementsForConnectionToServer.CheckMenuItem;
import frame.frameElements.elementsForConnectionToServer.ConnectionMenuItem;
import frame.frameElements.elementsForConnectionToServer.DisconnectionMenuItem;

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
        ConnectionMenuItem menuItem = new ConnectionMenuItem();
        JMenuItem connectionMenuItem = menuItem.getConnectionMenuItem();
        menu.add(connectionMenuItem);
    }

    private void addDisconnectionMenuItemToMenu() {
        DisconnectionMenuItem menuItem = new DisconnectionMenuItem();
        JMenuItem disconnectionMenuItem = menuItem.getDisconnectionMenuItem();
        menu.add(disconnectionMenuItem);
    }

    private void addCheckMenuItemToMenu() {
        CheckMenuItem menuItem = new CheckMenuItem();
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
