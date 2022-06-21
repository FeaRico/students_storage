package ru.makhach.studentsstorage.config.connect.postgresql;

import ru.makhach.studentsstorage.config.connect.DbConnection;

import java.sql.Connection;
import java.util.Optional;

public abstract class PostgresConnection extends DbConnection {
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
