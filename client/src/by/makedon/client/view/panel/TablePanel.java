package by.makedon.client.view.panel;

import by.makedon.client.table.PersonInformationTable;

import javax.swing.*;

public class TablePanel {
    private JScrollPane tablePanel;

    public TablePanel(PersonInformationTable personInformationTable) {
        tablePanel = new JScrollPane(personInformationTable.getTable());
    }

    public JScrollPane getTablePanel() {
        return tablePanel;
    }
}