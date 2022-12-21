package se.lexicon;

import se.lexicon.Exception.JDBCConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String USER = "bob";
    private static  final String PASS = "Tesfaldet@19";
    private  static  final String URL = "jdbc:mysql://localhost:3306/world";

    public static Connection getConnection() throws JDBCConnectionException {
        try {

            Connection connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("line 18 MySqlConnection" + connection);
            return connection;

        } catch (SQLException e) {
            throw new JDBCConnectionException("Database connection failed");
        }
    }
}

