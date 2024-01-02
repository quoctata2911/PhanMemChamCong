/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author vuqua
 */
public class DatabaseConnection {
     public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName=PMChamCong";
            String username = "sa";
            String password = "1";

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
