package ru.makhach.studentsstorage.dao.impl;

import ru.makhach.studentsstorage.config.connect.postgresql.MainPostgresConnection;
import ru.makhach.studentsstorage.config.connect.postgresql.StudentsPostgresConnection;
import ru.makhach.studentsstorage.dao.DatabaseDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DatabaseDaoImpl implements DatabaseDao {
    private final MainPostgresConnection mainConnection;
    private final StudentsPostgresConnection studentsConnection;

    private static final String EXISTS_DB = "select exists(SELECT datname FROM pg_catalog.pg_database WHERE lower(datname) = lower('" + StudentsPostgresConnection.DB_NAME + "'))";
    private static final String CREATE_DB = "CREATE DATABASE " + StudentsPostgresConnection.DB_NAME;

    public DatabaseDaoImpl() {
        this.mainConnection = MainPostgresConnection.getInstance();
        this.studentsConnection = StudentsPostgresConnection.getInstance();
    }

    @Override
    public void initializeDatabase() {
        Optional<Connection> optionalConnection = mainConnection.getConnection();
        optionalConnection.ifPresent(connection -> {
            try {
                Statement statement = connection.createStatement();
                if (!existDb(statement))
                    statement.executeUpdate(CREATE_DB);
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private boolean existDb(Statement statement) throws SQLException {
        statement.executeQuery(EXISTS_DB);
        ResultSet rs = statement.getResultSet();
        if (rs.next())
            return rs.getBoolean("exists");
        return false;
    }

    @Override
    public void initializeTable() {
        Optional<Connection> optionalConnection = studentsConnection.getConnection();
        optionalConnection.ifPresent(connection -> {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(getTableQuery());
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private String getTableQuery() {
        List<String> strings = null;
        try {
            String resource = Objects.requireNonNull(getClass().getResource("/table.init")).getPath();
            strings = Files.readAllLines(Paths.get(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        if (Objects.requireNonNull(strings).size() > 0)
            strings.forEach(result::append);
        return result.toString();
    }
}
