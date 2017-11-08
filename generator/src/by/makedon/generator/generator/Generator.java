package by.makedon.generator.generator;

import by.makedon.generator.database.BookOfReferenceDB;

public class Generator {
    public void generate(String arg) {
        final int COUNT = Integer.parseInt(arg);
        BookOfReferenceDB db = new BookOfReferenceDB(COUNT);
        db.start();
    }
}