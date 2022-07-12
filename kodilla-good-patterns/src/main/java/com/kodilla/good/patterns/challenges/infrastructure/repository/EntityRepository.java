package com.kodilla.good.patterns.challenges.infrastructure.repository;

import com.kodilla.good.patterns.challenges.infrastructure.ComponentRegistry;
import com.kodilla.good.patterns.challenges.infrastructure.dataSource.DataSourceInterface;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.*;
import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

@Repository
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

    @SaveMethod
    public EntityInterface save(EntityInterface entity) {
        if (entity.getId().isEmpty()) {
            String id = prepareIdForNewEntity(entity);
            entity.setId(id);
            map.put(id, entity);
        } else {
            map.put(entity.getId().get(), entity);
        }

        if (entity.getId().isEmpty()) {
            throw new RuntimeException("Order can't be save");
        }

        saveRelation(entity);

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

    private void saveRelation(EntityInterface entity) {
        saveOneToOneRelation(entity);
        saveOneToManyRelation(entity);
    }

    private void saveOneToManyRelation(EntityInterface entity) {
        findOneToManyRelation(entity)
                .forEach(field ->
                        Arrays.stream(getRepositoryClassForFieldWithOneToManyRelation(field).getMethods())
                                .filter(method -> method.isAnnotationPresent(SaveMethod.class))
                                .findFirst()
                                .ifPresent(method -> {
                                    try {
                                        field.setAccessible(true);
                                        var children = (Collection<EntityInterface>) field.get(entity);
                                        children.forEach(element -> {
                                            try {
                                                invokeSaveMethodOnmToMany(field, method, element);
                                            } catch (IllegalAccessException e) {
                                                throw new RuntimeException(e);
                                            } catch (InvocationTargetException e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    } catch (Exception exception) {
                                        throw new RuntimeException(exception);
                                    } finally {
                                        field.setAccessible(false);
                                    }
                                })
                );
    }

    private void invokeSaveMethodOnmToMany(Field field, Method method, EntityInterface element) throws IllegalAccessException, InvocationTargetException {
        method.invoke(ComponentRegistry
                .get(getRepositoryClassForFieldWithOneToManyRelation(field)), element);
    }

    private Class<? extends EntityRepositoryInterface> getRepositoryClassForFieldWithOneToManyRelation(Field field) {
        return field
                .getAnnotation(OneToMany.class)
                .targetEntity()
                .getAnnotation(Entity.class)
                .repository();
    }

    private Stream<Field> findOneToManyRelation(EntityInterface entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> (field.isAnnotationPresent(OneToMany.class))
                        && !field.getAnnotation(OneToMany.class).cascade().equals(CascadeType.None));
    }

    private void saveOneToOneRelation(EntityInterface entity) {
        findOneToOneRelation(entity)
                .forEach(field -> {
                    Arrays.stream(getRepositoryClassForFieldWithOneToOneRelation(field)
                                    .getMethods())
                            .filter(method -> method.isAnnotationPresent(SaveMethod.class))
                            .findFirst()
                            .ifPresent(method -> {
                                try {
                                    field.setAccessible(true);
                                    invokeSaveMethodOneToOne(entity, field, method);
                                } catch (Exception exception) {
                                    throw new RuntimeException();
                                } finally {
                                    field.setAccessible(false);
                                }
                            });
                });
    }

    private void invokeSaveMethodOneToOne(EntityInterface entity, Field field, Method method) throws IllegalAccessException, InvocationTargetException {
        method.invoke(ComponentRegistry.get(getRepositoryClassForFieldWithOneToOneRelation(field)), field.get(entity));
    }

    private Class<? extends EntityRepositoryInterface> getRepositoryClassForFieldWithOneToOneRelation(Field field) {
        return field.getType()
                .getAnnotation(Entity.class)
                .repository();
    }

    private Stream<Field> findOneToOneRelation(EntityInterface entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(OneToOne.class)
                        && !field.getAnnotation(OneToOne.class).cascade().equals(CascadeType.None));
    }
}
