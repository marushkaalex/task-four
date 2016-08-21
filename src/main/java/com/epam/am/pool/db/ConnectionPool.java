package com.epam.am.pool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool instance;

    private Connection connection;

    private ConnectionPool(Properties properties) {
        try {
            // TODO read from properties
            Class.forName(properties.getProperty("cp.driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("cp.uri"),
                    properties.getProperty("cp.username"),
                    properties.getProperty("cp.password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void init(Properties properties) {
        instance = new ConnectionPool(properties);
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
