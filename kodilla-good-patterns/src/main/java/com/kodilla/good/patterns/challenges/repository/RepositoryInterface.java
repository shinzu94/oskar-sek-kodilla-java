package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.entity.EntityInterface;

import java.util.Optional;

public interface RepositoryInterface {
    String save(EntityInterface entity);

    Optional<EntityInterface> find(String id);
}
