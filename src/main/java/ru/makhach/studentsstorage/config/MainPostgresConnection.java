package ru.makhach.studentsstorage.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainPostgresConnection extends PostgresConnection {
    private final static MainPostgresConnection instance;

    static {
        instance = new MainPostgresConnection();
    }

    public static MainPostgresConnection getInstance() {
        return instance;
    }

    @Override
    protected Connection getManagedConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
