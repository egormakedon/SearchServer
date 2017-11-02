package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisconnectionDialog extends Dialog {
    private JButton button ;
    private ClientController clientController;
    static Logger logger = LogManager.getLogger(DisconnectionDialog.class);

    public DisconnectionDialog(String TITLE, ClientController clientController) {
        super(TITLE);
        this.clientController = clientController;
        button = new JButton("Disconnect");
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
        ButtonListener buttonListener = new ButtonListener();
        button.addActionListener(buttonListener);
        dialog.add(button);
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (clientController.disconnect()) {
                logger.log(Level.INFO,"ClientSocket disconnected");
            } else {
                JOptionPane.showMessageDialog(dialog, "ClientSocket haven't connected yet");
                logger.log(Level.ERROR,"ClientSocket haven't connected yet");
            }
        }
    }
}