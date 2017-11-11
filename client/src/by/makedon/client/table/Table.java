package by.makedon.client.table;

import javax.swing.*;

public interface Table {
    JTable getTable();
    void add(String[] string);
    void clearTable();
    void updateTable();
}