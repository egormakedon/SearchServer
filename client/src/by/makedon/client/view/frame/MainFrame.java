package by.makedon.client.view.frame;

import by.makedon.client.controller.ClientController;
import by.makedon.client.table.Table;
import by.makedon.client.view.panel.MenuBar;
import by.makedon.client.view.panel.SearchPanel;
import by.makedon.client.view.panel.TablePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private ClientController clientController;
    private Table table = new Table();

    public MainFrame(ClientController clientController) {
        final String TITLE = "Book Of Reference";
        frame = new JFrame(TITLE);
        this.clientController = clientController;
    }

    public void set() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize();
        addElements();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void setSize() {
        final int MIN_WIDTH = 1600;
        final int MIN_HEIGHT = 900;
        frame.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
    }

    private void addElements() {
        addMenuBar();
        addSearchPanel();
        addTablePanel();
    }

    private void addMenuBar() {
        MenuBar menuBar = new MenuBar(clientController);
        menuBar.set();
        frame.setJMenuBar(menuBar.getMenuBar());
    }

    private void addSearchPanel() {
        SearchPanel panel = new SearchPanel(clientController, table);
        panel.set();
        frame.add(panel.getPanel(), BorderLayout.NORTH);
    }

    private void addTablePanel() {
        TablePanel panel = new TablePanel(table);
        frame.add(panel.getTablePanel(), BorderLayout.CENTER);
    }
}