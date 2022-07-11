package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;

import java.util.Map;
import java.util.Optional;

public interface EntityRepositoryInterface {
    Optional<EntityInterface> find(String id);

    Map<String, EntityInterface> findAll();
}
