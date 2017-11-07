package by.makedon.client.view.searchelement;

import by.makedon.client.controller.ClientController;
import by.makedon.client.criteria.Criteria;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.exception.WrongDataInputException;
import by.makedon.client.table.PersonInformationTable;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchButton {
    private JButton searchButton;
    private ClientController clientController;
    private SearchCriteria searchCriteria;
    private PersonInformationTable personInformationTable;
    static Logger logger = LogManager.getLogger(SearchButton.class);

    public SearchButton(ClientController clientController, SearchCriteria searchCriteria, PersonInformationTable personInformationTable) {
        final String TITLE = "search";
        searchButton = new JButton(TITLE);
        this.clientController = clientController;
        this.searchCriteria = searchCriteria;
        this.personInformationTable = personInformationTable;
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
                List<String> personInformation = clientController.sendQuery(criteriaMap);
                if (!personInformation.isEmpty()) {
                    clientController.refreshTable(personInformationTable, personInformation);
                } else {
                    JOptionPane.showMessageDialog(null, "Information haven't found");
                }
            } catch (WrongDataInputException | WrongConnectionException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
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
