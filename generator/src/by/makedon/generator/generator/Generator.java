package by.makedon.generator.generator;

import by.makedon.generator.creator.QueryCreator;
import by.makedon.generator.database.BookOfReferenceDB;

public class Generator {
    public void generate(String arg) {
        int count = Integer.parseInt(arg);
        BookOfReferenceDB db = new BookOfReferenceDB();
        db.refresh();
        QueryCreator queryCreator = new QueryCreator();
        for (int index = 0; index < count; index++) {
            final String QUERY = queryCreator.create();
            db.add(QUERY);
        }
    }
}
