package by.makedon.client.view.panel;

import by.makedon.client.controller.ClientController;
import by.makedon.client.view.searchelement.SearchButton;
import by.makedon.client.view.searchelement.SearchCriteria;

import javax.swing.*;
import java.awt.*;

public class SearchPanel {
    private JPanel panel;
    private ClientController clientController;
    private SearchCriteria searchCriteria;

    public SearchPanel(ClientController clientController) {
        panel = new JPanel();
        searchCriteria = new SearchCriteria();
        this.clientController = clientController;
    }

    public void set() {
        setSize();
        setLayout();
        addElements();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void setSize() {
        final int WIDTH = 0;
        final int HEIGHT = 50;
        panel.setSize(new Dimension(WIDTH, HEIGHT));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setLayout() {
        final int ROW = 1;
        final int COL = 6;
        panel.setLayout(new GridLayout(ROW, COL));
    }

    private void addElements() {
        addSearchCriteria();
        addSearchButton();
    }

    private void addSearchCriteria() {
        searchCriteria.set();
        panel.add(searchCriteria.getFirstname());
        panel.add(searchCriteria.getLastname());
        panel.add(searchCriteria.getPhone());
        panel.add(searchCriteria.getEmail());
        panel.add(searchCriteria.getSkype());
    }

    private void addSearchButton() {
        SearchButton searchButton = new SearchButton(clientController, searchCriteria);
        searchButton.set();
        panel.add(searchButton.getSearchButton());
    }
}
