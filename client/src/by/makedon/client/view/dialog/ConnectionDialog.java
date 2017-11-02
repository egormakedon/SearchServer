package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;
import by.makedon.client.exception.WrongConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionDialog extends Dialog {
    private ClientController clientController;
    private JTextField ipField = new JTextField();
    private JTextField portField = new JTextField();
    private JButton button = new JButton("Connect");
    static Logger logger = LogManager.getLogger(ConnectionDialog.class);

    public ConnectionDialog(String TITLE) {
        super(TITLE);
    }
    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void set() {
        setSize();
        setDialog();
        setLayout();
        addIp();
        addPort();
        addButton();
    }

    private void setLayout() {
        final int ROWS = 3;
        final int COLS = 2;
        dialog.setLayout(new GridLayout(ROWS, COLS));
    }

    private void addIp() {
        JLabel label = new JLabel("ip");
        dialog.add(label);
        dialog.add(ipField);
    }

    private void addPort() {
        JLabel label = new JLabel("port");
        dialog.add(label);
        dialog.add(portField);
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
            String ip = ipField.getText();
            String port = portField.getText();
            try {
                clientController.connect(ip, port);
            } catch (WrongConnectionException exc) {
                JOptionPane.showMessageDialog(null, "Exception. Check log.");
                logger.log(Level.ERROR, exc.getMessage());
            }
        }
    }
}