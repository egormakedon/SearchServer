package frame;

import frame.frameElements.FrMenu;
import frame.frameElements.FrMenuBar;
import frame.frameElements.SearchButton;
import frame.frameElements.SearchLine;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame fr = new JFrame();

    public MainFrame() {
        setFrMinSize();
        setFr();
        setFrTitle();
        addMenuBarOnFrame();
        addMenuOnMenuBar();
        addSearchLineOnFrame();
        addSearchButtonOnFrame();
    }

    private void setFr() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setExtendedState(Frame.MAXIMIZED_BOTH);
        fr.setLayout(null);
        fr.setVisible(true);
    }

    private void setFrMinSize() {
        final int MIN_WIDTH = 1600;
        final int MIN_HEIGHT = 900;

        fr.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
    }

    private void setFrTitle() {
        final String FR_TITLE = new String ("Encyclopedia client");

        fr.setTitle(FR_TITLE);
    }

    private void addMenuBarOnFrame() {
        FrMenuBar menuBar = new FrMenuBar();
        ElementManager.addMenuBarOnFr(fr, menuBar.getMenuBar());
    }

    private void addMenuOnMenuBar() {
        FrMenu menu = new FrMenu();
        ElementManager.addMenuOnMenuBar(fr.getJMenuBar(), menu.getMenu());
    }

    private void addSearchLineOnFrame() {
        SearchLine sLine = new SearchLine();
        ElementManager.addSearchLineOnFr(fr, sLine.getsLine());
    }

    private void addSearchButtonOnFrame() {
        SearchButton sButt = new SearchButton();
        ElementManager.addSearchButtonOnFr(fr, sButt.getsButt());
    }

    public void showFr() {
        fr.setVisible(true);
    }
}
