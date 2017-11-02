package by.makedon.client.view.menu;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.menuitem.ExitMenuItem;
import by.makedon.client.view.menuitem.DisconnectionMenuItem;
import by.makedon.client.view.menuitem.CheckMenuItem;
import by.makedon.client.view.menuitem.ConnectionMenuItem;

import javax.swing.*;

public class Menu {
    private JMenu menu;
    private ClientController clientController;

    public Menu(ClientController clientController) {
        final String TITLE = "<html><font style=’italic’ size = 4>Menu</html>";
        menu = new JMenu(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        addConnectionMenuItem();
        addDisconnectionMenuItem();
        addCheckMenuItem();
        menu.addSeparator();
        addExitMenuItem();
    }

    public JMenu getMenu() {
        return menu;
    }

    private void addConnectionMenuItem() {
        ConnectionMenuItem menuItem = new ConnectionMenuItem(clientController);
        menuItem.set();
        menu.add(menuItem.getConnectionMenuItem());
    }

    private void addDisconnectionMenuItem() {
        DisconnectionMenuItem menuItem = new DisconnectionMenuItem(clientController);
        menuItem.set();
        menu.add(menuItem.getDisconnectionMenuItem());
    }

    private void addCheckMenuItem() {
        CheckMenuItem menuItem = new CheckMenuItem(clientController);
        menuItem.set();
        menu.add(menuItem.getCheckMenuItem());
    }

    private void addExitMenuItem() {
        ExitMenuItem menuItem = new ExitMenuItem(clientController);
        menuItem.set();
        menu.add(menuItem.getExitMenuItem());
    }
}