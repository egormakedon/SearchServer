package by.makedon.client.parser;

public class StringParser {
    public String[] parse(final String STRING, final String DELIMITER) {
        return STRING.split(DELIMITER);
    }
}