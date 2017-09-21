package frame;

import javax.swing.*;

class ElementManager {
    static void addMenuBarOnFr(JFrame fr, JMenuBar menuBar) {
        fr.setJMenuBar(menuBar);
    }

    static void addMenuOnMenuBar(JMenuBar menuBar, JMenu menu) {
        menuBar.add(menu);
    }

    static void addSearchLineOnFr(JFrame fr, JTextField sLine) {
        fr.add(sLine);
    }

    static void addSearchButtonOnFr(JFrame fr, JButton sButt) {
        fr.add(sButt);
    }
}
