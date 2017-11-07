package by.makedon.server.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookOfReferenceDB {
    private final String USER = "root";
    private final String URL = "jdbc:mysql://localhost:3306/book_of_reference";
    private final String PASSWORD = "elzzz147";
    static Logger logger = LogManager.getLogger(BookOfReferenceDB.class);

    public BookOfReferenceDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            logger.log(Level.INFO, "Set mysql driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARN, e);
        }
    }

    public List<String> findPersonInformation(final String QUERY) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> personInformationList = new ArrayList<String>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.log(Level.INFO, "Have opened connection to DB");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                final String RESULT = resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                                      resultSet.getString(3) + " " + resultSet.getString(4) + " " +
                                      resultSet.getString(5) + " " + resultSet.getString(6);
                personInformationList.add(RESULT);
            }
        } catch (SQLException e) {
            logger.log(Level.WARN, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.log(Level.WARN, e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.log(Level.WARN, e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    logger.log(Level.INFO, "Have closed connection to DB");
                } catch (SQLException e) {
                    logger.log(Level.WARN, e);
                }
            }
        }
        return personInformationList;
    }
}