package by.makedon.client.view.searchelement;

import by.makedon.client.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton {
    private JButton searchButton;
    private ClientController clientController;
    private SearchCriteria searchCriteria;

    public SearchButton(ClientController clientController, SearchCriteria searchCriteria) {
        final String TITLE = "search";
        searchButton = new JButton(TITLE);
        this.clientController = clientController;
        this.searchCriteria = searchCriteria;
    }

    class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void set() {
        setSearchButton();
        addListener();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    private void setSearchButton() {
        searchButton.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        searchButton.setFont(new Font("", Font.ITALIC, 20));
        searchButton.setBackground(Color.WHITE);
    }

    private void addListener() {
        searchButton.addActionListener(new SearchAction());
    }
}
