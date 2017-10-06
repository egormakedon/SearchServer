package dialog;

import javax.swing.*;
import java.awt.*;

public class Dialog {
    protected JDialog dialog = new JDialog();

    public Dialog(String TITLE) {
        setTitle(TITLE);
    }

    private void setTitle(String TITLE) {
        dialog.setTitle(TITLE);
    }

    protected void setSize() {
        final int WIDTH = 600;
        final int HEIGHT = 300;
        dialog.setSize(new Dimension(WIDTH, HEIGHT));
        dialog.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        dialog.setResizable(false);
    }

    protected void setDialog() {
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
    }

    public void show() {
        dialog.setVisible(true);
    }
}
