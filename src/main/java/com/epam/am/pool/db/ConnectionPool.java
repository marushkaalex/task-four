package com.epam.am.pool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool instance;

    private Connection connection;

    private ConnectionPool() {
        try {
            // TODO read from properties
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        instance = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
