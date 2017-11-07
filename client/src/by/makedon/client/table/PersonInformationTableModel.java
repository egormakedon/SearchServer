package by.makedon.client.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PersonInformationTableModel extends AbstractTableModel {
    private int columnCount = 6;
    private List<String[]> personInformationList;

    PersonInformationTableModel() {
        personInformationList = new ArrayList<String[]>();
    }

    @Override
    public int getRowCount() {
        return personInformationList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return personInformationList.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "id";
            case 1: return "firstname";
            case 2: return "lastname";
            case 3: return "phone";
            case 4: return "email";
            case 5: return "skype";
            default: return null;
        }
    }

    void addPersonInformation(String[] personInformation) {
        personInformationList.add(personInformation);
    }

    void clear() {
        personInformationList.clear();
    }
}