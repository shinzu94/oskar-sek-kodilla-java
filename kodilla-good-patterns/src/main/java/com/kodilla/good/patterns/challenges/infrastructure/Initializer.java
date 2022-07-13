package com.kodilla.good.patterns.challenges.infrastructure;

import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInitializer;
import com.kodilla.good.patterns.challenges.infrastructure.repository.RepositoryInitializer;

abstract public class Initializer {
    public static final String PROJECT_PACKAGE = "com.kodilla.good.patterns.challenges";
    private static Boolean isInitialize = false;

    public static void init() {
        if (!isInitialize) {
            EntityInitializer.init(PROJECT_PACKAGE);
            RepositoryInitializer.init(PROJECT_PACKAGE);

            isInitialize = true;
        }
    }
}
