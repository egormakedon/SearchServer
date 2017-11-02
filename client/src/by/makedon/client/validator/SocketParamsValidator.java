package by.makedon.client.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocketParamsValidator {
    public boolean validationIp(String ip) {
        final String REGEX_IP = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        Pattern pattern = Pattern.compile(REGEX_IP);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public boolean validationPort(String port) {
        final String REGEX_PORT = "\\d{4}";
        Pattern pattern = Pattern.compile(REGEX_PORT);
        Matcher matcher = pattern.matcher(port);
        return matcher.matches();
    }
}