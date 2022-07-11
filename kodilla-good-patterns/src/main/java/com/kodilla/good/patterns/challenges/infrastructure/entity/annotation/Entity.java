package com.kodilla.good.patterns.challenges.infrastructure.entity.annotation;

import com.kodilla.good.patterns.challenges.repository.EntityRepositoryInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Entity {
    Class<? extends EntityRepositoryInterface> repository();
}