package frame.frameElements.searchElements;

import javax.swing.*;
import java.awt.*;

public class PanelForSearchElements {
    private JPanel panel = new JPanel();

    public PanelForSearchElements() {
        setPanel();
        setPanelSize();
        addSearchLineToPanel();
        addSearchButtonToPanel();
    }

    private void setPanel() {
        panel.setLayout(null);
    }

    private void setPanelSize() {
        final int WIDTH = 0;
        final int HEIGHT = 80;

        panel.setSize(new Dimension(WIDTH, HEIGHT));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void addSearchLineToPanel() {
        SearchLine sLine = new SearchLine();
        JTextField searchLine = sLine.getsLine();
        panel.add(searchLine);
    }

    private void addSearchButtonToPanel() {
        SearchButton sButt = new SearchButton();
        JButton searchButton = sButt.getsButt();
        panel.add(searchButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
