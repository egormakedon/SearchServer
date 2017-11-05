package by.makedon.server.controller;

import by.makedon.server.database.BookOfReferenceDB;

import java.util.List;

class Controller {
    synchronized List<String> findPersonInformation(final String QUERY) {
        BookOfReferenceDB db = new BookOfReferenceDB();
        return db.findPersonInformation(QUERY);
    }
}
