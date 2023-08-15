package com.javarush.jira.initializer;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ConfigurationReader {

    public static final String APPLICATION_TEST_YML = "src/test/resources/application-test.yaml";
    public static final String VERSION = "version";
    public static final String DATABASE = "database";
    public static final String FAILED_TO_LOAD_POSTGRES_VERSION_FROM_CONFIGURATION = "Failed to load Postgres version from configuration";

    @SuppressWarnings("unchecked")
    public static String getPostgresVersion() {
        Yaml yaml = new Yaml();
        Path path = Paths.get(APPLICATION_TEST_YML);

        try (InputStream in = Files.newInputStream(path)) {
            Map<String, Object> obj = yaml.load(in);
            Map<String, Object> databaseMap = (Map<String, Object>) obj.get(DATABASE);
            Object versionObject = databaseMap.get(VERSION);
            return String.valueOf(versionObject);
        } catch (Exception e) {
            throw new RuntimeException(FAILED_TO_LOAD_POSTGRES_VERSION_FROM_CONFIGURATION, e);
        }
    }
}