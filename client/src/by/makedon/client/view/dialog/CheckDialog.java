package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheckDialog extends Dialog {
    private ClientController clientController;
    private JButton printButton;
    private JButton saveButton;

    public CheckDialog(String TITLE, ClientController clientController) {
        super(TITLE);
        this.clientController = clientController;
        printButton = new JButton("print session");
        saveButton = new JButton("save session");
    }

    public void set() {
        setSize();
        setDialog();
        addElements();
    }

    private void addElements() {
        addConnectionInfoPanel();
    }

    private void addConnectionInfoPanel() {
        JPanel panel = createConnectionInfoPanel();
        List<String> connectionInfoList = clientController.getConnectionInfo();

        JLabel ip;
        JLabel port;
        JLabel connection;
        if (connectionInfoList.get(2).equals("TRUE")) {
            ip = new JLabel("<html><center>ip: " + connectionInfoList.get(0) +"</html>");
            port = new JLabel("<html><center>port: " + connectionInfoList.get(1) +"</html>");
            connection = new JLabel();
            connection.setBackground(Color.GREEN);
        } else {
            ip = new JLabel("<html><center>ip:</html>");
            port = new JLabel("<html><center>port:</html>");
            connection = new JLabel();
            connection.setBackground(Color.RED);
        }

        panel.add(ip);
        panel.add(port);
        connection.setOpaque(true);
        panel.add(connection);
        dialog.add(panel, BorderLayout.NORTH);
    }

    private JPanel createConnectionInfoPanel() {
        JPanel panel = new JPanel();

        final int ROWS = 1;
        final int COLS = 6;
        panel.setLayout(new GridLayout(ROWS, COLS));

        final int WIDTH = 600;
        final int HEIGHT = 35;
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setSize(new Dimension(WIDTH,HEIGHT));
        return panel;
    }
}