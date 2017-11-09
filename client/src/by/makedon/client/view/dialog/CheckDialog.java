package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.parser.XmlSessionParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class CheckDialog extends Dialog {
    private ClientController clientController;
    private JButton printButton;
    private JButton saveButton;
    static Logger logger = LogManager.getLogger(CheckDialog.class);

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

    class PrintAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SessionDialog sessionDialog = new SessionDialog(clientController);
            try {
                sessionDialog.set();
            } catch (WrongConnectionException e1) {
                logger.log(Level.ERROR, e1);
                JOptionPane.showMessageDialog(dialog, e1.getMessage());
            }
        }
    }

    class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<String> sessionList = clientController.sessionRequest();
                XmlSessionParser xmlParser = new XmlSessionParser();

                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.xml", "xml");
                fileChooser.setFileFilter(filter);

                int ret = fileChooser.showDialog(dialog, "save session");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    xmlParser.parse(file, sessionList);
                }
            } catch (WrongConnectionException e1) {
                logger.log(Level.ERROR, e1);
                JOptionPane.showMessageDialog(dialog, e1.getMessage());
            }
        }
    }

    @Override
    void setSize() {
        final int WIDTH = 300;
        final int HEIGHT = 300;
        dialog.setSize(new Dimension(WIDTH, HEIGHT));
        dialog.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        dialog.setResizable(false);
    }

    private void addElements() {
        JPanel panel = createConnectionInfoPanel();

        addConnectionInfoPanel(panel);
        addPrintButton(panel);
        addSaveButton(panel);

        dialog.add(panel);
    }

    private void addConnectionInfoPanel(JPanel panel) {
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
    }

    private void addPrintButton(JPanel panel) {
        printButton.addActionListener(new PrintAction());
        panel.add(printButton);
    }

    private void addSaveButton(JPanel panel) {
        saveButton.addActionListener(new SaveAction());
        panel.add(saveButton);
    }

    private JPanel createConnectionInfoPanel() {
        JPanel panel = new JPanel();

        final int ROWS = 5;
        final int COLS = 1;
        panel.setLayout(new GridLayout(ROWS, COLS));

        final int WIDTH = 300;
        final int HEIGHT = 300;
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setSize(new Dimension(WIDTH,HEIGHT));
        return panel;
    }
}