package by.makedon.client.view.dialog;

import by.makedon.client.controller.Controller;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionDialog extends Dialog {
    private JButton button = new JButton("Disconnect");
    private Controller controller;
    static Logger logger = LogManager.getLogger(DisconnectionDialog.class);

    public DisconnectionDialog(String TITLE) {
        super(TITLE);
    }

    public void setController(Controller controller) {
        this.controller = controller;
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
            if (controller.disconnect()) {
                logger.log(Level.INFO, "ClientSocket disconnected");
            } else {
                logger.log(Level.ERROR, "ClientSocket haven't connected yet");
            }
        }
    }
}