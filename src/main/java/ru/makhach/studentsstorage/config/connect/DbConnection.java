package ru.makhach.studentsstorage.config.connect;

import ru.makhach.studentsstorage.config.ApplicationProperties;

import java.util.Optional;
import java.util.Properties;

public abstract class DbConnection {
    protected static final String URL;
    protected static final String DB_USER;
    protected static final String DB_PASS;
    protected static final String DB_DRIVER;
    protected static Properties properties;

    static {
        properties = ApplicationProperties.getProps();
        URL = properties.getProperty("db.url");
        DB_USER = properties.getProperty("db.user");
        DB_PASS = properties.getProperty("db.password");
        DB_DRIVER = properties.getProperty("db.driver");
    }

    public abstract Optional<java.sql.Connection> getConnection();
}
