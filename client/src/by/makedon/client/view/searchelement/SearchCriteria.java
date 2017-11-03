package by.makedon.client.view.searchelement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchCriteria {
    private JTextField firstname;
    private JTextField lastname;
    private JTextField phone;
    private JTextField email;
    private JTextField skype;

    public SearchCriteria() {
        final int COL = 30;
        firstname = new JTextField(COL);
        lastname = new JTextField(COL);
        phone = new JTextField(COL);
        email = new JTextField(COL);
        skype = new JTextField(COL);
    }

    public void set() {
        setInitialText();

        setCriteria(firstname);
        setCriteria(lastname);
        setCriteria(phone);
        setCriteria(email);
        setCriteria(skype);

        setPromptText(firstname, "firstname");
        setPromptText(lastname, "lastname");
        setPromptText(phone, "phone");
        setPromptText(email, "email");
        setPromptText(skype, "skype");
    }

    public JTextField getFirstname() {
        return firstname;
    }

    public JTextField getLastname() {
        return lastname;
    }

    public JTextField getPhone() {
        return phone;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getSkype() {
        return skype;
    }

    private void setCriteria(JTextField criteria) {
        criteria.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        criteria.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        criteria.setCaretColor(Color.RED);
        criteria.setFont(new Font("", Font.ITALIC, 20));
    }

    private void setPromptText(JTextField criteria, final String TEXT) {
        criteria.setToolTipText(TEXT);
        criteria.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (criteria.getText().equals(TEXT)) {
                    criteria.setText("");
                    criteria.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (criteria.getText().isEmpty()) {
                    criteria.setText(TEXT);
                    criteria.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void setInitialText() {
        firstname.setText("firstname");
        lastname.setText("lastname");
        phone.setText("phone");
        email.setText("email");
        skype.setText("skype");

        firstname.setForeground(Color.GRAY);
        lastname.setForeground(Color.GRAY);
        phone.setForeground(Color.GRAY);
        email.setForeground(Color.GRAY);
        skype.setForeground(Color.GRAY);
    }
}
