package com.kodilla.good.patterns.challenges.infrastructure.entity;

import com.kodilla.good.patterns.challenges.repository.EntityRepositoryInterface;

import java.util.Optional;

public interface EntityInterface {
    Optional<String> getId();

    EntityInterface setId(String id);

    String generateId();

    Class<? extends EntityRepositoryInterface> getRepositoryClass();
}
