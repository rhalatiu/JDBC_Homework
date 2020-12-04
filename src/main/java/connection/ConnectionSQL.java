package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/JDBC_Homework";
    private String user = "postgres";
    private String password = "postgres";

    public ConnectionSQL connect(){
        ConnectionSQL conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        ConnectionSQL app = new ConnectionSQL();
        app.connect();
    }
}