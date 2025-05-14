package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    public static Connection con;

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public DAO() {
        if (con == null) {
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=CAR_RENTAL_SHOP;encrypt=true;trustServerCertificate=true";
            String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "sa", "123456");
                System.out.println("Connect success");
            } catch (Exception e) {
                System.out.println("Connect fail");
                e.printStackTrace();
            }
        }
    }
}
