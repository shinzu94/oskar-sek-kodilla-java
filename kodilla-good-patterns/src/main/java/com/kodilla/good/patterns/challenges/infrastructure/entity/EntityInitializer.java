package com.kodilla.good.patterns.challenges.infrastructure.entity;

import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Entity;
import com.kodilla.good.patterns.challenges.infrastructure.entity.annotation.Id;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

abstract public class EntityInitializer {

    public static void init(final String projectPackage) {
        Reflections reflections = new Reflections(projectPackage, new SubTypesScanner(false));
        validateIllegalUseOfEntityAnnotation(reflections);

        List<Class<? extends AbstractEntity>> classWithAnnotation = findLegalUseOfEntityAnnotation(reflections);
        validateIdAnnotation(classWithAnnotation);
    }

    private static void validateIdAnnotation(List<Class<? extends AbstractEntity>> classWithAnnotation) {
        classWithAnnotation.forEach(oClass -> {
            List<Field> fieldsWithIdAnnotation = Arrays.stream(oClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Id.class))
                    .collect(Collectors.toList());

            if (fieldsWithIdAnnotation.size() != 1) {
                throw new RuntimeException("Entity need Id");
            }

            Field idField = fieldsWithIdAnnotation.stream().findFirst().get();
            if (idField.getType() != UUID.class) {
                throw new RuntimeException("Invalid type of Id");
            }
        });
    }

    private static List<Class<? extends AbstractEntity>> findLegalUseOfEntityAnnotation(Reflections reflections) {
        return reflections.getSubTypesOf(AbstractEntity.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Entity.class))
                .collect(Collectors.toList());
    }

    private static void validateIllegalUseOfEntityAnnotation(Reflections reflections) {
        long countOfIllegalClass = reflections.getSubTypesOf(Object.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Entity.class))
                .filter(oClass -> !oClass.getSuperclass().equals(AbstractEntity.class))
                .count();
        if (countOfIllegalClass > 0) {
            throw new RuntimeException("Annotation " + Entity.class.getName() + " can be use only by children of " + AbstractEntity.class.getName());
        }
    }
}
