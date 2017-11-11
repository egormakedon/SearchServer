package by.makedon.client.table;

import javax.swing.*;

public class PersonInformationTable implements Table {
    private JTable table;
    private PersonInformationTableModel model;

    public PersonInformationTable() {
        model = new PersonInformationTableModel();
        table = new JTable(model);
    }

    @Override
    public JTable getTable() {
        return table;
    }

    @Override
    public void add(String[] personInformation) {
        model.addPersonInformation(personInformation);
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