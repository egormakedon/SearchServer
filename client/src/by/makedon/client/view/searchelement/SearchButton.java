package by.makedon.client.view.searchelement;

import by.makedon.client.controller.ClientController;
import by.makedon.client.criteria.Criteria;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.exception.WrongDataInputException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SearchButton {
    private JButton searchButton;
    private ClientController clientController;
    private SearchCriteria searchCriteria;
    static Logger logger = LogManager.getLogger(SearchButton.class);

    public SearchButton(ClientController clientController, SearchCriteria searchCriteria) {
        final String TITLE = "search";
        searchButton = new JButton(TITLE);
        this.clientController = clientController;
        this.searchCriteria = searchCriteria;
    }

    class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Map<Criteria, String> criteriaMap = new HashMap<Criteria, String>();
            criteriaMap.put(Criteria.FIRSTNAME, searchCriteria.getFirstname().getText());
            criteriaMap.put(Criteria.LASTNAME, searchCriteria.getLastname().getText());
            criteriaMap.put(Criteria.PHONE, searchCriteria.getPhone().getText());
            criteriaMap.put(Criteria.EMAIL, searchCriteria.getEmail().getText());
            criteriaMap.put(Criteria.SKYPE, searchCriteria.getSkype().getText());

            try {
                clientController.sendQuery(criteriaMap);
            } catch (WrongDataInputException e1) {
                JOptionPane.showMessageDialog(null, "Wrong Input Data.\nText fields have 30 sym maximum.\n" +
                        "First and Last names begin with high register.\n" +
                        "Phone consists of 9 numbers");
                logger.log(Level.ERROR, "Wrong Input Data");
            } catch (WrongConnectionException e1) {
                JOptionPane.showMessageDialog(null, "Client hasn't connected to Server");
                logger.log(Level.ERROR, e1);
            }
        }
    }

    public void set() {
        setSearchButton();
        addListener();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    private void setSearchButton() {
        searchButton.setBorder(BorderFactory.createMatteBorder(1,5,1,1, Color.RED));
        searchButton.setFont(new Font("", Font.ITALIC, 20));
        searchButton.setBackground(Color.WHITE);
    }

    private void addListener() {
        searchButton.addActionListener(new SearchAction());
    }
}
