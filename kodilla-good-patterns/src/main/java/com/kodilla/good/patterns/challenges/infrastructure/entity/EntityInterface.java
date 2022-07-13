package com.kodilla.good.patterns.challenges.infrastructure.entity;

import java.util.Optional;

public interface EntityInterface {
    Optional<String> getId();

    void setId(String id);

    String generateId();
}
