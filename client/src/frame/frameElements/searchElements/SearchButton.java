package frame.frameElements.searchElements;

import javax.swing.*;
import java.awt.*;

public class SearchButton {
    private JButton sButt = new JButton();

    public SearchButton() {
        setsButt();
        setsButtSize();
        setsButtTitle();
        setsButtLocation();
    }

    private void setsButt() {
        sButt.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        sButt.setFont(new Font("", Font.ITALIC, 20));
        sButt.setBackground(Color.WHITE);
    }

    private void setsButtSize() {
        final int WIDTH = 100;
        final int HEIGHT = 27;

        sButt.setSize(new Dimension(WIDTH, HEIGHT));
        sButt.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setsButtTitle() {
        final String SEARCH = new String("Search");

        sButt.setText(SEARCH);
    }

    private void setsButtLocation() {
        final int X = 1100;
        final int Y = 25;

        sButt.setLocation(X, Y);
    }

    public JButton getsButt() {
        return sButt;
    }
}
