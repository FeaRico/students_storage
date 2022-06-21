package ru.makhach.studentsstorage.config.connect.postgresql;

import ru.makhach.studentsstorage.config.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Реализация соединения к серверу БД PostgreSQL с подключением к определенной БД
 */
public class StudentsPostgresConnection extends PostgresConnection {
    public static final String DB_NAME;

    public final static StudentsPostgresConnection instance;

    static {
        instance = new StudentsPostgresConnection();
        DB_NAME = ApplicationProperties.getProps().getProperty("db.name");
    }

    public static StudentsPostgresConnection getInstance() {
        return instance;
    }

    @Override
    protected Connection getManagedConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL + DB_NAME, DB_USER, DB_PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
