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
    private JTextField ipField;
    private JTextField portField;
    private JButton button;
    static Logger logger = LogManager.getLogger(ConnectionDialog.class);

    public ConnectionDialog(String TITLE, ClientController clientController) {
        super(TITLE);
        this.clientController = clientController;
        ipField = new JTextField();
        portField = new JTextField();
        button = new JButton("Connect");
    }

    public void set() {
        setSize();
        setDialog();
        setLayout();
        addElement();
    }

    private void setLayout() {
        final int ROWS = 3;
        final int COLS = 2;
        dialog.setLayout(new GridLayout(ROWS, COLS));
    }

    private void addElement() {
        addIp();
        addPort();
        addButton();
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
        ButtonListener buttonListener = new ButtonListener();
        button.addActionListener(buttonListener);
        dialog.add(button);
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ip = ipField.getText();
            String port = portField.getText();
            try {
                clientController.connect(ip, port);
            } catch (WrongConnectionException e1) {
                JOptionPane.showMessageDialog(dialog,"Wrong connect to server");
                logger.log(Level.ERROR, e1);
            }
        }
    }
}