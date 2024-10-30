package singleresponsability;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConexion {

    static String url = "jdbc:mysql://mysql-3c3763b1-brandodbtest.e.aivencloud.com:12741";
    static String user = "avnadmin";
    static String password = "AVNS_W-_wHM4NXXC31MfqtLG";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos");
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
