package school.siit;

import connection.ConnectionSQL;
import org.junit.Test;

import java.sql.*;

public class Tests {
    @Test
    public void test1() throws SQLException {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/JDBC_Homework";
        String user = "postgres";
        String password = "postgres";

        ConnectionSQL conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query = " insert into accomodation (type, bed_type, max_guests, description)"
                + " values (?, ?, ?, ?) RETURNING id";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, "double room");
        preparedStmt.setString(2, "king size");
        preparedStmt.setInt(3, 2);
        preparedStmt.setString(4, "big room, view at the ocean");



        int affectedRows = preparedStmt.executeUpdate();
        int id;


        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = (int) generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        preparedStmt.close();

        String query2 = " select from accomodation where id = " + String.valueOf(id);

        PreparedStatement preparedStmt2 = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStmt.setString(1, "double room");
        preparedStmt.setString(2, "king");
        preparedStmt.setInt(3, 3);
        preparedStmt.setString(4, "big room, view at the ocean");




        connection.close();
    }

    @Test
    public void test2() throws SQLException{
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/JDBC_Homework";
        String user = "postgres";
        String password = "postgres";

        ConnectionSQL conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
