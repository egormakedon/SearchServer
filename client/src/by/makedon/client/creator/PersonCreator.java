package by.makedon.client.creator;

import by.makedon.client.model.Person;
import by.makedon.client.parser.PersonInformationParser;

public class PersonCreator {
    public Person create(String person) {
        PersonInformationParser parser = new PersonInformationParser();
        String[] personCriteriaList = parser.parse(person, " ");
        final String ID = personCriteriaList[0];
        final String FIRSTNAME = personCriteriaList[1];
        final String LASTNAME = personCriteriaList[2];
        final String PHONE = personCriteriaList[3];
        final String EMAIL = personCriteriaList[4];
        final String SKYPE = personCriteriaList[5];
        return new Person(Long.parseLong(ID), FIRSTNAME, LASTNAME, Integer.parseInt(PHONE), EMAIL, SKYPE);
    }
}
