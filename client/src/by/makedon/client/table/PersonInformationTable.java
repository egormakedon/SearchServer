package by.makedon.client.table;

import javax.swing.*;

public class PersonInformationTable extends Table{
    private JTable table;
    private PersonInformationTableModel personInformationTableModel;

    public PersonInformationTable() {
        personInformationTableModel = new PersonInformationTableModel();
        table = new JTable(personInformationTableModel);
    }

    public JTable getTable() {
        return table;
    }

    public void add(String[] personInformation) {
        personInformationTableModel.addPersonInformation(personInformation);
    }

    public void clearTable() {
        personInformationTableModel.clear();
    }
}