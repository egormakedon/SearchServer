package frame;

import javax.swing.*;

class ElementManager {
    static void addMenuBarToFr(JFrame fr, JMenuBar menuBar) {
        fr.setJMenuBar(menuBar);
    }

    static void addMenuToMenuBar(JMenuBar menuBar, JMenu menu) {
        menuBar.add(menu);
    }

    static void addPanelToFr(JFrame fr, JPanel panel, String BLAYOUT) {
        fr.add(panel, BLAYOUT);
    }
}
