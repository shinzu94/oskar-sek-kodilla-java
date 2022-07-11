package com.kodilla.good.patterns.challenges.infrastructure.entity.annotation;

import com.kodilla.good.patterns.challenges.infrastructure.entity.AbstractEntity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

abstract public class EntityInitializer {

    public static void init(final String projectPackage) {
        Reflections reflections = new Reflections(projectPackage, new SubTypesScanner(false));
        long countOfIllegalClass = findIllegalUseOfEntityAnntotation(reflections);
        if (countOfIllegalClass > 0) {
            throw new RuntimeException("Annotation " + Entity.class.getName() + " can be use only by children of " + AbstractEntity.class.getName());
        }
        List<Class<? extends AbstractEntity>> classWithAnnotation = findLegalUseOfEntityAnnotation(reflections);
        prepareIdAnnotation(classWithAnnotation);
    }

    private static void prepareIdAnnotation(List<Class<? extends AbstractEntity>> classWithAnnotation) {
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

            updateIdField(oClass, idField);
        });
    }

    private static void updateIdField(Class oClass, Field idField) {
        Optional<Field> optionalField = Arrays.stream(oClass.getSuperclass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(IdField.class))
                .findFirst();

        optionalField.ifPresent(field -> {
            try {
                field.setAccessible(true);
                field.set(null, idField);
                field.setAccessible(false);
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), exception.getCause());
            }
        });
    }

    private static List<Class<? extends AbstractEntity>> findLegalUseOfEntityAnnotation(Reflections reflections) {
        return reflections.getSubTypesOf(AbstractEntity.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Entity.class))
                .collect(Collectors.toList());
    }

    private static long findIllegalUseOfEntityAnntotation(Reflections reflections) {
        return reflections.getSubTypesOf(Object.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Entity.class)
                        && !oClass.getSuperclass().equals(AbstractEntity.class))
                .count();
    }
}
