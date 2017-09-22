package frame.frameElements.elementsForConnectionToServer.dialog;

import javax.swing.*;
import java.awt.*;

public class Dialog {
    protected JDialog dialog = new JDialog();

    public Dialog(String TITLE) {
        setDialogSize();
        setDialog();
        setDialogTitle(TITLE);
    }

    private void setDialog() {
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
    }

    private void setDialogTitle(String TITLE) {
        dialog.setTitle(TITLE);
    }

    private void setDialogSize() {
        final int WIDTH = 600;
        final int HEIGHT = 300;

        dialog.setSize(new Dimension(WIDTH, HEIGHT));
        dialog.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        dialog.setResizable(false);
    }

    public void show() {
        dialog.setVisible(true);
    }
}
