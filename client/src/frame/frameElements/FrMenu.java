package frame.frameElements;

import javax.swing.*;

public class FrMenu {
    private JMenu menu = new JMenu();

    public FrMenu() {
        setMenu();
    }

    private void setMenu() {
        menu.setText("<html><font style=’italic’ size = 4>Menu</html>");
    }

    public JMenu getMenu() {
        return menu;
    }
}
