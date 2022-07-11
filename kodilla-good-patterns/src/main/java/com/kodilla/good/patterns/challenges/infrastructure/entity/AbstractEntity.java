package com.kodilla.good.patterns.challenges.infrastructure.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

abstract public class AbstractEntity implements EntityInterface {

    @Override
    public Optional<String> getId() {
        try {
            Field field = getIdField().get();
            if (field.getType() == UUID.class) {
                field.setAccessible(true);
                UUID idValue = (UUID) field.get(this);
                field.setAccessible(false);
                if (idValue != null) {
                    return Optional.of(idValue.toString());
                }
            } else {
                throw new RuntimeException("Invalid type of Id");
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), exception.getCause());
        }
        return Optional.empty();
    }

    @Override
    public EntityInterface setId(String id) {
        try {
            Field field = getIdField().get();
            if (field.getType() == UUID.class) {
                UUID idValue = UUID.fromString(id);
                field.setAccessible(true);
                field.set(this, idValue);
                field.setAccessible(false);
            } else {
                throw new RuntimeException("Invalid type of Id");
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), exception.getCause());
        }
        return this;
    }

    public String generateId() {
        String result = null;
        try {
            Field field = getIdField().get();
            if (field.getType() == UUID.class) {
                field.setAccessible(true);
                UUID idValue = (UUID) field.get(this);
                field.setAccessible(false);
                if (idValue == null) {
                    result = UUID.randomUUID().toString();
                }
            } else {
                throw new RuntimeException("Invalid type of Id");
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), exception.getCause());
        }
        return result;
    }

    private Optional<Field> getIdField() {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst();
    }
}
