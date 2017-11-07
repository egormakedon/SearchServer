package by.makedon.client.controller;

import by.makedon.client.creator.QueryCreator;
import by.makedon.client.criteria.Criteria;
import by.makedon.client.exception.WrongConnectionException;
import by.makedon.client.exception.WrongDataInputException;
import by.makedon.client.parser.PersonInformationParser;
import by.makedon.client.table.PersonInformationTable;
import by.makedon.client.validator.CriteriaValidator;
import by.makedon.client.validator.SocketParamsValidator;

import java.util.List;
import java.util.Map;

public class ClientController {
    private ClientSocketProcessor clientSocketProcessor;
    public ClientController(ClientSocketProcessor clientSocketProcessor) {
        this.clientSocketProcessor = clientSocketProcessor;
    }

    public void connect(String ip, String port) throws WrongConnectionException {
        SocketParamsValidator validator = new SocketParamsValidator();
        if (!validator.validationIp(ip)) {
            throw new WrongConnectionException("Invalid ip: " + ip);
        }
        if (!validator.validationPort(port)) {
            throw new WrongConnectionException("Invalid port: " + port);
        }
        if (clientSocketProcessor.isConnection()) {
            throw new WrongConnectionException("Tried to set connection when you have already connected");
        }
        clientSocketProcessor.createClientSocket(ip, Integer.parseInt(port));
    }

    public boolean disconnect() {
        return clientSocketProcessor.closeClientSocket();
    }

    public List<String> getConnectionInfo() {
        List<String> connectionInfoList = clientSocketProcessor.getConnectionInfo();
        if (clientSocketProcessor.isConnection()) {
            final String TRUE = "TRUE";
            connectionInfoList.add(TRUE);
        } else {
            final String FALSE = "FALSE";
            connectionInfoList.add(FALSE);
        }
        return connectionInfoList;
    }

    public List<String> sendQuery(Map<Criteria, String> criteriaMap) throws WrongDataInputException, WrongConnectionException {
        CriteriaValidator criteriaValidator = new CriteriaValidator();
        if (!criteriaValidator.validationCriteria(criteriaMap)) {
            throw new WrongDataInputException("Wrong Input Data.\nText fields have 30 sym maximum.\n" +
                    "First and Last names begin with high register.\n" +
                    "Phone consists of 9 numbers");
        }
        if (!clientSocketProcessor.isConnection()) {
            throw new WrongConnectionException("Client hasn't connected to Server");
        }
        QueryCreator queryCreator = new QueryCreator();
        final String QUERY = queryCreator.create(criteriaMap);
        return clientSocketProcessor.findPersonInformation(QUERY);
    }

    public void refreshTable(PersonInformationTable personInformationTable, List<String> personInformation) {
        personInformationTable.clearTable();
        PersonInformationParser parser = new PersonInformationParser();
        for (String person : personInformation) {
            personInformationTable.addPersonInformation(parser.parse(person, " "));
        }
        personInformationTable.getTable().revalidate();
    }
}
