package dialog;

import clientController.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionDialog extends Dialog {
    private Controller controller;

    private JTextField ipField = new JTextField();
    private JTextField portField = new JTextField();
    private JButton button = new JButton("Connect");

    public ConnectionDialog(String TITLE) {
        super(TITLE);
    }

    public void setController(Controller controller) {
        this.controller = controller;
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
            controller.connect(ip, port);
        }
    }

}
