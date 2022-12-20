package se.lexicon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionExamples {
        public static void main(String[] args) {
            ex1();
        }

        public static void ex1() {
            String query = "select * from city";

            try (
                    Connection myconn = MySqlConnection.getConnection();
                    Statement mystat = myconn.createStatement();
                    ResultSet resultSet = mystat.executeQuery(query);

            ) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("Name"));
                    System.out.println(resultSet.getString("CountryCode"));
                }

            } catch (JDBCConnectionException | SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

