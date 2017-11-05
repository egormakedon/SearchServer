package by.makedon.client.parser;

public class PersonInformationParser {
    public String[] parse(final String PERSON, final String DELIMITER) {
        return PERSON.split(DELIMITER);
    }
}