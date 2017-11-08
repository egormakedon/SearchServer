package by.makedon.client.table;

import javax.swing.*;

public class SessionTable extends Table {
    private JTable table;
    private SessionTableModel sessionTableModel;

    public SessionTable() {
        sessionTableModel = new SessionTableModel();
        table = new JTable(sessionTableModel);
    }

    public JTable getTable() {
        return table;
    }

    public void add(String[] session) {
        sessionTableModel.addSession(session);
    }

    public void clearTable() {
        sessionTableModel.clear();
    }
}