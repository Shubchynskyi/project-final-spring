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

    private static PostgreSQLContainer<?> container;

    public static void initializeContainer(String postgresVersion) {
        container = new PostgreSQLContainer<>("postgres:" + postgresVersion);
    }

    public static PostgreSQLContainer<?> getContainer() {
        if (container == null) {
            throw new IllegalStateException("Container is not initialized yet!");
        }
        return container;
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
            PostgreSQLContainer<?> container = PostgresTestContainersInitializer.getContainer();
            TestPropertyValues.of(
                    "spring.datasource.url=" + container.getJdbcUrl(),
                    "spring.datasource.username=" + container.getUsername(),
                    "spring.datasource.password=" + container.getPassword()
            ).applyTo(applicationContext);
        }
    }
}

