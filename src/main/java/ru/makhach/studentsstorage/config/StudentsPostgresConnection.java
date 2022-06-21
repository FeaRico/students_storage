package ru.makhach.studentsstorage.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentsPostgresConnection extends PostgresConnection {
    public static final String DB_NAME = "students_abd";

    public final static StudentsPostgresConnection instance;

    static {
        instance = new StudentsPostgresConnection();
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
