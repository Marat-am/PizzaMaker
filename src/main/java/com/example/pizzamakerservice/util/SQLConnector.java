package com.example.pizzamakerservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

    public static final String user = "root";
    public static final String password="root";
    public static final String DB = "PizzaMakerService";
    public static final String url = "jdbc:mysql:// localhost:3306/" + DB;


    private static Connection connection = null;

    private SQLConnector() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
