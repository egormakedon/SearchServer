package by.makedon.client.view.dialog;

import by.makedon.client.controller.ClientController;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.table.SessionTable;

import javax.swing.*;
import java.awt.*;

class SessionDialog {
    private ClientController clientController;
    private JFrame frame;
    private SessionTable sessionTable;


    SessionDialog(ClientController clientController) {
        this.clientController = clientController;
        frame = new JFrame("Session...");
        sessionTable = new SessionTable();
    }

    public void set() throws WrongConnectionException {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize();
        sessionRequest();
        addTable();
        show();
    }

    private void setSize() {
        final int W = 600;
        final int H = 400;
        frame.setSize(new Dimension(W, H));
        frame.setPreferredSize(new Dimension(W, H));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    private void addTable() {
        JScrollPane scrollPane = new JScrollPane(sessionTable.getTable());
        frame.add(scrollPane);
    }

    private void sessionRequest() throws WrongConnectionException {
        clientController.refreshTable(sessionTable, clientController.sessionRequest());
    }

    private void show() {
        frame.setVisible(true);
    }
}
