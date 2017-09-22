package frame.frameElements.searchElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchLine {
    private JTextField sLine = new JTextField();

    public SearchLine() {
        setsLine();
        setsLineSize();
        setsLineLocation();
        setToolTipAndBefTextMessage();
        setInitialText();
    }

    private void setsLine() {
        sLine.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        sLine.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        sLine.setCaretColor(Color.RED);
        sLine.setFont(new Font("", Font.ITALIC, 20));
    }

    private void setsLineSize() {
        final int WIDTH = 900;
        final int HEIGHT = 27;

        sLine.setSize(new Dimension(WIDTH, HEIGHT));
        sLine.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setsLineLocation() {
        final int X = 150;
        final int Y = 25;

        sLine.setLocation(X, Y);
    }

    private void setToolTipAndBefTextMessage() {
        final String SEARCH_LINE = new String("Search Line");
        sLine.setToolTipText(SEARCH_LINE);
        sLine.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                String sLineText = sLine.getText();
                if (sLineText.equals(SEARCH_LINE)) {
                    sLine.setText("");
                    sLine.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String sLineText = sLine.getText();
                if (checkEmptyString(sLineText)) {
                    sLine.setText(SEARCH_LINE);
                    sLine.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void setInitialText() {
        final String SEARCH_LINE = new String("Search Line");
        sLine.setText(SEARCH_LINE);
        sLine.setForeground(Color.GRAY);
    }

    private boolean checkEmptyString(String str) {
        if (str.equals("")) return true;
        return false;
    }

    public JTextField getsLine() {
        return sLine;
    }
}
