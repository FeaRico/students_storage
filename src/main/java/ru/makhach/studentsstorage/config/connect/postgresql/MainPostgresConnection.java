package ru.makhach.studentsstorage.config.connect.postgresql;

import ru.makhach.studentsstorage.utils.Logger;
import ru.makhach.studentsstorage.config.connect.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Реализация соединения к серверу БД PostgreSQL без подключения к определенной БД.
 * Необходим в том числе для автоматического создания БД.
 */
public class MainPostgresConnection extends PostgresConnection {
    private final static MainPostgresConnection instance;
    private final Logger logger;

    static {
        instance = new MainPostgresConnection();
    }

    public MainPostgresConnection() {
        this.logger = Logger.getInstance();
    }

    public static MainPostgresConnection getInstance() {
        return instance;
    }

    @Override
    protected Connection getManagedConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbConnection.URL, DbConnection.DB_USER, DbConnection.DB_PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.showMessage(throwables.getLocalizedMessage());
        }
        return connection;
    }
}
