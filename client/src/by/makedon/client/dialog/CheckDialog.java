package by.makedon.client.dialog;

import javax.swing.*;
import java.awt.*;

public class CheckDialog extends Dialog {
    private JLabel ipLabel = new JLabel();
    private JLabel portLabel = new JLabel();
    private JLabel connectionLabel = new JLabel();

    public CheckDialog(String TITLE) {
        super(TITLE);
    }
    public void set() {
        setSize();
        setDialog();
        addConnectionInformationPanel();
    }
    private void addConnectionInformationPanel() {
        JPanel panel = createConnInfPanel();
        JLabel ip = new JLabel("<html><center>ip:</html>");
        JLabel port = new JLabel("<html><center>port:</html>");
        JLabel connection = new JLabel("<html><center>connection:</html>");
        panel.add(ip);
        panel.add(ipLabel);
        panel.add(port);
        panel.add(portLabel);
        panel.add(connection);
        connectionLabel.setOpaque(true);
        panel.add(connectionLabel);
        dialog.add(panel, BorderLayout.NORTH);
    }
    private JPanel createConnInfPanel() {
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
    public void setConnInfPanel(String[] strings) {
        ipLabel.setText(strings[0]);
        portLabel.setText(strings[1]);
        String[] color = parseString(strings[2]);
        connectionLabel.setBackground(new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])));
    }
    private String[] parseString(String string) {
        return string.split("\\s");
    }


}
