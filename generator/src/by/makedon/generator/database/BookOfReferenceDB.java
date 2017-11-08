package by.makedon.generator.database;

import by.makedon.generator.creator.QueryCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BookOfReferenceDB {
    private final String USER = "root";
    private final String URL = "jdbc:mysql://localhost:3306/book_of_reference";
    private final String PASSWORD = "elzzz147";
    private final int COUNT;

    public BookOfReferenceDB(final int COUNT) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.COUNT = COUNT;
    }

//    public void refresh() {
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            statement = connection.createStatement();
//
//            final String DELETE_STATEMENT = "DELETE FROM person_information;";
//            final String REFRESH_AUTO_INCREMENT = "ALTER TABLE person_information AUTO_INCREMENT=0;";
//            statement.executeUpdate(DELETE_STATEMENT);
//            statement.executeUpdate(REFRESH_AUTO_INCREMENT);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    public void add(final String QUERY) {
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            statement = connection.createStatement();
//            statement.executeUpdate(QUERY);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void start() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            final String DELETE_STATEMENT = "DELETE FROM person_information;";
            final String REFRESH_AUTO_INCREMENT = "ALTER TABLE person_information AUTO_INCREMENT=0;";
            statement.executeUpdate(DELETE_STATEMENT);
            statement.executeUpdate(REFRESH_AUTO_INCREMENT);

            QueryCreator queryCreator = new QueryCreator();
            for (int index = 0; index < COUNT; index++) {
                final String QUERY = queryCreator.create();
                statement.executeUpdate(QUERY);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}