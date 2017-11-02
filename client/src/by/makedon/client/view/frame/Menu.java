package by.makedon.client.view.frame;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.menuitem.ExitMenuItem;
import by.makedon.client.view.menuitem.DisconnectionMenuItem;
import by.makedon.client.view.menuitem.CheckMenuItem;
import by.makedon.client.view.menuitem.ConnectionMenuItem;

import javax.swing.*;

public class Menu {
    private JMenu menu = new JMenu();
    private ClientController clientController;

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void set() {
        setMenuTitle();
        addConnectionMenuItem();
        addDisconnectionMenuItem();
        addCheckMenuItem();
        menu.addSeparator();
        addExitMenuItem();
    }

    private void setMenuTitle() {
        final String TITLE = "<html><font style=’italic’ size = 4>Menu</html>";
        menu.setText(TITLE);
    }

    private void addConnectionMenuItem() {
        ConnectionMenuItem menuItem = new ConnectionMenuItem();
        menuItem.setClientController(clientController);
        menuItem.set();
        menu.add(menuItem.getConnectionMenuItem());
    }

    private void addDisconnectionMenuItem() {
        DisconnectionMenuItem menuItem = new DisconnectionMenuItem();
        menuItem.setClientController(clientController);
        menuItem.set();
        menu.add(menuItem.getDisconnectionMenuItem());
    }

    private void addCheckMenuItem() {
        CheckMenuItem menuItem = new CheckMenuItem();
        menuItem.setClientController(clientController);
        menuItem.set();
        menu.add(menuItem.getCheckMenuItem());
    }

    private void addExitMenuItem() {
        ExitMenuItem menuItem = new ExitMenuItem();
        menuItem.set();
        menu.add(menuItem.getExitMenuItem());
    }

    public JMenu getMenu() {
        return menu;
    }
}
