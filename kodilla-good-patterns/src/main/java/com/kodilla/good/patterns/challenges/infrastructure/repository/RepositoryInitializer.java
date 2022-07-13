package com.kodilla.good.patterns.challenges.infrastructure.repository;

import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

abstract public class RepositoryInitializer {

    public static void init(final String projectPackage) {
        Reflections reflections = new Reflections(projectPackage, new SubTypesScanner(false));
        validateIllegalUseOfRepositoryAnnotation(reflections);
    }

    private static void validateIllegalUseOfRepositoryAnnotation(Reflections reflections) {
        long count = reflections.getSubTypesOf(Object.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Repository.class))
                .filter(oClass -> !oClass.getSuperclass().equals(EntityRepository.class) && !oClass.equals(EntityRepository.class))
                .count();
        if (count > 0) {
            throw new RuntimeException("Annotation " + Repository.class.getName() + " can be use only by children of " + EntityRepository.class.getName());
        }
    }
}
