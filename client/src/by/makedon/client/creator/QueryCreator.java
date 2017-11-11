package by.makedon.client.creator;

import by.makedon.client.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static by.makedon.client.criteria.Criteria.PHONE;

public class QueryCreator {
    public String create(Map<Criteria, String> criteriaMap) {
        String query;
        if (criteriaMap.isEmpty()) {
            query = "SELECT * FROM person_information;";
        } else {
            List<String> criteriaStringList = new ArrayList<String>();
            for (Map.Entry<Criteria, String> entry : criteriaMap.entrySet()) {
                final String KEY = entry.getKey().toString().toLowerCase();
                final String VALUE = entry.getValue();
                String criteriaString;
                if (KEY.equals(PHONE.toString().toLowerCase())) {
                    criteriaString = KEY + "=" + VALUE;
                } else {
                    criteriaString = KEY + "=" + "\"" + VALUE + "\"";
                }
                criteriaStringList.add(criteriaString);
            }
            final String QUERY_GENERAL_PART = "SELECT * FROM person_information WHERE ";
            final String QUERY_WHERE_PART = String.join(" AND ", criteriaStringList);
            query = QUERY_GENERAL_PART + QUERY_WHERE_PART + ";";
        }
        return query;
    }
}