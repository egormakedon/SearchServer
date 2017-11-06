package by.makedon.client.table;

import javax.swing.*;

public class Table extends JTable{
    private JTable table;
    private TableModel tableModel;

    public Table() {
        tableModel = new TableModel();
        table = new JTable(tableModel);
    }

    public JTable getTable() {
        return table;
    }

    public void addPersonInformation(String[] personInformation) {
        tableModel.addPersonInformation(personInformation);
    }

    public void clearTable() {
        tableModel.clear();
    }


}
