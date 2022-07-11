package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.infrastructure.dataSource.DataSourceInterface;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EntityRepository implements EntityRepositoryInterface {
    private static final DataSourceInterface dataSource = ComponentRegistry.getDataSourceInterface();
    protected final Map<String, EntityInterface> map;
    protected final Map<Class<? extends EntityInterface>, String> manyToOne = new HashMap<>();
    protected final Map<Class<? extends EntityInterface>, Map<String, EntityInterface>> oneToMany = new HashMap<>();
    protected Map<Class<? extends EntityInterface>, String> oneToOne = new HashMap<>();

    public EntityRepository(Class<? extends EntityInterface> entityClass) {
        map = dataSource.getData(entityClass);
    }

    public static EntityRepositoryInterface of(Class<? extends EntityInterface> entityClass) {
        try {
            Method method = entityClass.getMethod("getRepositoryClass");
            Object entityInstance = entityClass.newInstance();
            Class<? extends EntityRepositoryInterface> entityRepositoryClass = (Class<? extends EntityRepositoryInterface>) method.invoke(entityInstance);

            return entityRepositoryClass.newInstance();
        } catch (Exception exception) {
            return new EntityRepository(entityClass);
        }
    }

    public EntityInterface save(EntityInterface entity) {
        if (entity.getId().isEmpty()) {
            String id = prepareIdForNewEntity(entity);
            entity.setId(id);
            map.put(id, entity);
        } else {
            entity.getId().ifPresent(id -> map.put(id, entity));
        }
        if (entity.getId().isEmpty()) {
            throw new RuntimeException("Order can't be save");
        }
        return entity;
    }

    private String prepareIdForNewEntity(EntityInterface entity) {
        String id;
        do {
            id = entity.generateId();
        } while (map.containsKey(id));
        return id;
    }

    @Override
    public Optional<EntityInterface> find(String id) {
        return Optional.ofNullable(map.getOrDefault(id, null));
    }

    @Override
    public Map<String, EntityInterface> findAll() {
        return map;
    }
}
