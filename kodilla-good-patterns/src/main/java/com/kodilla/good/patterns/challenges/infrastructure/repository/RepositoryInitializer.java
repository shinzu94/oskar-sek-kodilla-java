package com.kodilla.good.patterns.challenges.infrastructure.repository;

import com.kodilla.good.patterns.challenges.infrastructure.repository.annotation.Repository;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

abstract public class RepositoryInitializer {

    public static void init(final String projectPackage) {
        Reflections reflections = new Reflections(projectPackage, new SubTypesScanner(false));
        long countOfIllegalClass = findIllegalUseOfRepositoryAnnotation(reflections);
        if (countOfIllegalClass > 0) {
            throw new RuntimeException("Annotation " + Repository.class.getName() + " can be use only by children of " + EntityRepository.class.getName());
        }
    }

    private static long findIllegalUseOfRepositoryAnnotation(Reflections reflections) {
        return reflections.getSubTypesOf(Object.class)
                .stream()
                .filter(oClass -> oClass.isAnnotationPresent(Repository.class)
                        && !oClass.getSuperclass().equals(EntityRepository.class))
                .count();
    }
}
