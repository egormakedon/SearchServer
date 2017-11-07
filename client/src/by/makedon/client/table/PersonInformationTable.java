package by.makedon.client.table;

import javax.swing.*;

public class PersonInformationTable extends JTable{
    private JTable table;
    private PersonInformationTableModel personInformationTableModel;

    public PersonInformationTable() {
        personInformationTableModel = new PersonInformationTableModel();
        table = new JTable(personInformationTableModel);
    }

    public JTable getTable() {
        return table;
    }

    public void addPersonInformation(String[] personInformation) {
        personInformationTableModel.addPersonInformation(personInformation);
    }

    public void clearTable() {
        personInformationTableModel.clear();
    }
}