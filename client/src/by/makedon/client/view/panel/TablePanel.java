package by.makedon.client.view.panel;

import by.makedon.client.table.Table;

import javax.swing.*;

public class TablePanel {
    private JScrollPane tablePanel;

    public TablePanel(Table table) {
        tablePanel = new JScrollPane(table.getTable());
    }

    public JScrollPane getTablePanel() {
        return tablePanel;
    }
}