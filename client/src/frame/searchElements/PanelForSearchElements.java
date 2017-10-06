package frame.searchElements;

import javax.swing.*;
import java.awt.*;

public class PanelForSearchElements {
    private JPanel panel = new JPanel();

    public void set() {
        setPanelSize();
        setPanel();
        addSearchLine();
        addSearchButton();
    }

    private void setPanelSize() {
        final int WIDTH = 0;
        final int HEIGHT = 80;
        panel.setSize(new Dimension(WIDTH, HEIGHT));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setPanel() {
        panel.setLayout(null);
    }

    private void addSearchLine() {
        SearchLine searchLine = new SearchLine();
        searchLine.set();
        panel.add(searchLine.getSearchLine());
    }

    private void addSearchButton() {
        SearchButton searchButton = new SearchButton();
        searchButton.set();
        panel.add(searchButton.getSearchButton());
    }

    public JPanel getPanel() {
        return panel;
    }
}
