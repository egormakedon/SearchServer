package by.makedon.client.searchElement;

import javax.swing.*;
import java.awt.*;

public class SearchButton {
    private JButton searchButton = new JButton();

    public void set() {
        setTitle();
        setSize();
        setLocation();
        setSearchButton();
    }

    private void setTitle() {
        final String SEARCH = new String("Search");
        searchButton.setText(SEARCH);
    }

    private void setSize() {
        final int WIDTH = 100;
        final int HEIGHT = 27;
        searchButton.setSize(new Dimension(WIDTH, HEIGHT));
        searchButton.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setLocation() {
        final int X = 1100;
        final int Y = 25;
        searchButton.setLocation(X, Y);
    }

    private void setSearchButton() {
        searchButton.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        searchButton.setFont(new Font("", Font.ITALIC, 20));
        searchButton.setBackground(Color.WHITE);
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
