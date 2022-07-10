package com.kodilla.good.patterns.challenges.entity;

import java.util.Optional;

public interface EntityInterface {
    Optional<String> getId();

    EntityInterface setId(String id);

    String generateId();
}
