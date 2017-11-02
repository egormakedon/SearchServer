package by.makedon.client.view.searchelement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchLine {
    private JTextField searchLine = new JTextField();

    public void set() {
        setSize();
        setLocation();
        setSearchLine();
        setToolTipAndBefTextMessage();
        setInitialText();
    }

    private void setSize() {
        final int WIDTH = 900;
        final int HEIGHT = 27;
        searchLine.setSize(new Dimension(WIDTH, HEIGHT));
        searchLine.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setLocation() {
        final int X = 150;
        final int Y = 25;
        searchLine.setLocation(X, Y);
    }

    private void setSearchLine() {
        searchLine.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        searchLine.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        searchLine.setCaretColor(Color.RED);
        searchLine.setFont(new Font("", Font.ITALIC, 20));
    }

    private void setToolTipAndBefTextMessage() {
        final String SEARCH_LINE = new String("Search Line");
        searchLine.setToolTipText(SEARCH_LINE);
        searchLine.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                String sLineText = searchLine.getText();
                if (sLineText.equals(SEARCH_LINE)) {
                    searchLine.setText("");
                    searchLine.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String sLineText = searchLine.getText();
                if (checkEmptyString(sLineText)) {
                    searchLine.setText(SEARCH_LINE);
                    searchLine.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void setInitialText() {
        final String SEARCH_LINE = new String("Search Line");
        searchLine.setText(SEARCH_LINE);
        searchLine.setForeground(Color.GRAY);
    }

    private boolean checkEmptyString(String str) {
        if (str.equals("")) return true;
        return false;
    }

    public JTextField getSearchLine() {
        return searchLine;
    }
}
