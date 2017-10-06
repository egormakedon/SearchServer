package dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionDialog extends Dialog {
    private JButton button = new JButton("Disconnect");

    public DisconnectionDialog(String TITLE) {
        super(TITLE);
    }

    public void set() {
        setSize();
        setDialog();
        setLayout();
        addButton();
    }

    private void setLayout() {
        dialog.setLayout(new GridBagLayout());
    }

    private void addButton() {
        setButtonListener();
        dialog.add(button);
    }

    private void setButtonListener() {
        ButtonListener buttonListener = new ButtonListener();
        button.addActionListener(buttonListener);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
