package by.makedon.client.table;

import javax.swing.*;

public class SessionTable implements Table {
    private JTable table;
    private SessionTableModel model;

    public SessionTable() {
        model = new SessionTableModel();
        table = new JTable(model);
    }

    @Override
    public JTable getTable() {
        return table;
    }

    @Override
    public void add(String[] session) {
        model.addSession(session);
    }

    @Override
    public void clearTable() {
        model.clear();
    }

    @Override
    public void updateTable() {
        table.revalidate();
    }
}