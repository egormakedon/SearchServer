package by.makedon.client.view.frame;

import by.makedon.client.controller.Controller;
import by.makedon.client.view.ExitMenuItem;
import by.makedon.client.view.DisconnectionMenuItem;
import by.makedon.client.view.CheckMenuItem;
import by.makedon.client.view.ConnectionMenuItem;

import javax.swing.*;

public class Menu {
    private JMenu menu = new JMenu();
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
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
        menuItem.setController(controller);
        menuItem.set();
        menu.add(menuItem.getConnectionMenuItem());
    }

    private void addDisconnectionMenuItem() {
        DisconnectionMenuItem menuItem = new DisconnectionMenuItem();
        menuItem.setController(controller);
        menuItem.set();
        menu.add(menuItem.getDisconnectionMenuItem());
    }

    private void addCheckMenuItem() {
        CheckMenuItem menuItem = new CheckMenuItem();
        menuItem.setController(controller);
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
