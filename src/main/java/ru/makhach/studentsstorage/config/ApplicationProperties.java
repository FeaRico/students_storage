package ru.makhach.studentsstorage.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class ApplicationProperties {

    public static Properties getProps() {
        Properties props = new Properties();

        Path propertyPath = Paths.get(Objects.requireNonNull(ApplicationProperties.class.getResource("/database.properties")).getPath());

        try {
            BufferedReader bf = Files.newBufferedReader(propertyPath, StandardCharsets.UTF_8);
            props.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}
