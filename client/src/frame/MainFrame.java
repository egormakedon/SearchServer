package frame;

import frame.frameElements.informationElements.InformationPanel;
import frame.frameElements.menuBar.menu.FrMenu;
import frame.frameElements.menuBar.FrMenuBar;
import frame.frameElements.searchElements.PanelForSearchElements;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame fr = new JFrame();

    public MainFrame() {
        setFrMinSize();
        setFr();
        setFrTitle();
        addMenuBarToFrame();
        addMenuToMenuBar();
        addPanelForSearchElementsToFrame();
        addInformationPanelToFrame();
    }

    private void setFr() {
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setExtendedState(Frame.MAXIMIZED_BOTH);
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

    private void addMenuBarToFrame() {
        FrMenuBar menuBar = new FrMenuBar();
        JMenuBar mBar = menuBar.getMenuBar();
        ElementManager.addMenuBarToFr(fr, mBar);
    }

    private void addMenuToMenuBar() {
        FrMenu menu = new FrMenu();
        JMenuBar menuBar = fr.getJMenuBar();
        JMenu jMenu = menu.getMenu();
        ElementManager.addMenuToMenuBar(menuBar, jMenu);
    }

    private void addPanelForSearchElementsToFrame() {
        PanelForSearchElements p = new PanelForSearchElements();
        JPanel panel = p.getPanel();
        final String BORDER_LAYOUT_NORTH = BorderLayout.NORTH;
        ElementManager.addPanelToFr(fr, panel, BORDER_LAYOUT_NORTH);
    }

    private void addInformationPanelToFrame() {
        InformationPanel panel = new InformationPanel();
        JPanel informationPanel = panel.getInformationPanel();
        final String BORDER_LAYOUT_CENTER = BorderLayout.CENTER;
        ElementManager.addPanelToFr(fr, informationPanel, BORDER_LAYOUT_CENTER);
    }

    public void showFr() {
        fr.setVisible(true);
    }
}
