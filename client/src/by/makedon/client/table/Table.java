package by.makedon.client.table;

import javax.swing.*;

public abstract class Table {
    public abstract JTable getTable();
    public abstract void add(String[] string);
    public abstract void clearTable();
}
