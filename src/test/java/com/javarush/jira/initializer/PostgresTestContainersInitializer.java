package com.javarush.jira.initializer;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

// TODO task 4 - testcontainers
@UtilityClass
public class PostgresTestContainersInitializer {

    public static final String CONTAINER_IS_NOT_INITIALIZED_YET = "Container is not initialized yet!";
    public static final String POSTGRES = "postgres:";
    private static PostgreSQLContainer<?> container;

    public static void initializeContainer(String postgresVersion) {
        container = new PostgreSQLContainer<>(POSTGRES + postgresVersion);
    }

    public static PostgreSQLContainer<?> getContainer() {
        if (container == null) {
            throw new IllegalStateException(CONTAINER_IS_NOT_INITIALIZED_YET);
        }
        return container;
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public static final String SPRING_DATASOURCE_URL = "spring.datasource.url=";
        public static final String SPRING_DATASOURCE_USERNAME = "spring.datasource.username=";
        public static final String SPRING_DATASOURCE_PASSWORD = "spring.datasource.password=";

        @Override
        public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
            PostgreSQLContainer<?> container = PostgresTestContainersInitializer.getContainer();
            TestPropertyValues.of(
                    SPRING_DATASOURCE_URL + container.getJdbcUrl(),
                    SPRING_DATASOURCE_USERNAME + container.getUsername(),
                    SPRING_DATASOURCE_PASSWORD + container.getPassword()
            ).applyTo(applicationContext);
        }
    }
}

