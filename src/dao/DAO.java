package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=CAR_RENTAL_SHOP;encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi driver SQL Server.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
