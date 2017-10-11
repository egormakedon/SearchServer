package by.makedon.client.frameEntity;

import by.makedon.client.controller.Controller;
import by.makedon.client.informationElement.InformationPanel;
import by.makedon.client.searchElement.PanelForSearchElements;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame fr = new JFrame();
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void set() {
        setFrTitle();
        setFrMinSize();
        setFr();
        addMenuBar();
        addMenu();
        addPanelForSearchElements();
        addInformationPanel();
    }

    private void setFrTitle() {
        final String FR_TITLE = new String ("Encyclopedia client");
        fr.setTitle(FR_TITLE);
    }

    private void setFrMinSize() {
        final int MIN_WIDTH = 1600;
        final int MIN_HEIGHT = 900;
        fr.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
    }

    private void setFr() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    private void addMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.set();
        fr.setJMenuBar(menuBar.getMenuBar());
    }

    private void addMenu() {
        Menu menu = new Menu();
        menu.setController(controller);
        menu.set();
        JMenuBar menuBar = fr.getJMenuBar();
        menuBar.add(menu.getMenu());
    }

    private void addPanelForSearchElements() {
        PanelForSearchElements panel = new PanelForSearchElements();
        panel.set();
        fr.add(panel.getPanel(), BorderLayout.NORTH);
    }

    private void addInformationPanel() {
        InformationPanel panel = new InformationPanel();
        fr.add(panel.getInformationPanel(), BorderLayout.CENTER);
    }

    public void show() {
        fr.setVisible(true);
    }
}
