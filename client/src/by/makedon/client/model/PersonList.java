package by.makedon.client.model;

import by.makedon.client.creator.PersonCreator;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList = new ArrayList<Person>();

    private PersonList() {}

    private static class SingletonHolder {
        private final static PersonList INSTANCE = new PersonList();
    }

    public static PersonList getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void clear() {
        personList.clear();
    }

    public void add(List<String> personInformation) {
        PersonCreator personCreator = new PersonCreator();
        for (String person : personInformation) {
            personList.add(personCreator.create(person));
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
