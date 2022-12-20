package se.lexicon;

import java.sql.*;

public class JDBCConnectionExamples {
        public static void main(String[] args) {
            ex2();
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
    public static void ex2() {

        String query = "select * from city where id = ? and Name like ? and CountryCode like ?";

        int cityId = 3;
        try (
                Connection connection = MySqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {

            preparedStatement.setInt(1, cityId);
            preparedStatement.setString(2, "H" + "%");
            preparedStatement.setString(3,"A" + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("Name"));
                    System.out.println(resultSet.getString("CountryCode"));
                    System.out.println("-------------");
                }

            }

        } catch (JDBCConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    }

