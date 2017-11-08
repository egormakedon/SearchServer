package by.makedon.client.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SessionTableModel extends AbstractTableModel {
    private int columnCount = 2;
    private List<String[]> sessionList;

    SessionTableModel() {
        sessionList = new ArrayList<String[]>();
    }

    @Override
    public int getRowCount() {
        return sessionList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return sessionList.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "date";
            case 1: return "message";
            default: return null;
        }
    }

    void addSession(String[] session) {
        sessionList.add(session);
    }

    void clear() {
        sessionList.clear();
    }
}
