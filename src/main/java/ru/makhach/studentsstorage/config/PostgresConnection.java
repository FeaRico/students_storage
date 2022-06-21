package ru.makhach.studentsstorage.config;

import java.sql.Connection;
import java.util.Optional;

public abstract class PostgresConnection {
    protected static final String URL = "jdbc:postgresql://localhost:5432/";
    protected static final String DB_USER = "postgres";
    protected static final String DB_PASS = "123456789";
    protected static final String DB_DRIVER = "org.postgresql.Driver";

    public Optional<Connection> getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = getManagedConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(connection);
    }

    protected abstract Connection getManagedConnection();
}
