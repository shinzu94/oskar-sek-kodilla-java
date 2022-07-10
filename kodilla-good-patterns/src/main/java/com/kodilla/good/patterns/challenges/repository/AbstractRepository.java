package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.entity.EntityInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

abstract public class AbstractRepository implements RepositoryInterface {
    public String save(EntityInterface entity) {
        if (!getList().contains(entity)) {
            List<String> ids = getList().stream().map(entityElement -> entityElement.getId().orElse("")).collect(Collectors.toList());
            String id;
            do {
                id = entity.generateId();
            } while (ids.contains(id));
            entity.setId(id);
            getList().add(entity);
        } else {
            getList().set(getList().indexOf(entity), entity);
        }
        return entity.getId().orElseThrow(() -> new RuntimeException("Order can't be save"));
    }

    @Override
    public Optional<EntityInterface> find(String id) {
        return getList().stream()
                .filter(entity -> {
                    Optional<String> entityId = entity.getId();
                    return entityId.isPresent() && entityId.get().equals(id);
                })
                .findFirst();
    }

    abstract protected List<EntityInterface> getList();
}
