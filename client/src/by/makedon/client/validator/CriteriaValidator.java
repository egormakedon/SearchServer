package by.makedon.client.validator;

import by.makedon.client.criteria.Criteria;

import java.util.Map;
import java.util.regex.Pattern;

public class CriteriaValidator {
    public boolean validationCriteria(Map<Criteria, String> criteriaMap) {
        return validationOnEmptyFields(criteriaMap) || validationAllCriteria(criteriaMap);
    }

    private boolean validationOnEmptyFields(Map<Criteria, String> criteriaMap) {
        boolean result = true;
        for (Map.Entry entry : criteriaMap.entrySet()) {
            if (!entry.getKey().toString().equals(entry.getValue().toString().toUpperCase())) {
                result = false;
                break;
            }
        }

        if (result) criteriaMap.clear();
        return result;
    }

    private boolean validationAllCriteria(Map<Criteria, String> criteriaMap) {
        boolean result = true;
        for (Map.Entry<Criteria, String> entry : criteriaMap.entrySet()) {
            if (!factory(entry)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean factory(Map.Entry<Criteria, String> entry) {
        boolean result;

        final String NAME_REGEX = "([A-Z]{1}[a-z]{1,29})";
        final String PHONE_REGEX = "(\\d{9})";

        switch (entry.getKey()) {
            case FIRSTNAME:
                result = Pattern.matches(NAME_REGEX, entry.getValue());
                break;
            case LASTNAME:
                result = Pattern.matches(NAME_REGEX, entry.getValue());
                break;
            case PHONE:
                result = Pattern.matches(PHONE_REGEX, entry.getValue());
                break;
            case EMAIL:
                result = true;
                break;
            case SKYPE:
                result = true;
                break;
            default:
                result = false;
                break;
        }
        return result;
    }
}
