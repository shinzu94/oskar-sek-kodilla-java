package com.kodilla.good.patterns.challenges.infrastructure.entity.annotation;

import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OneToMany {
    CascadeType cascade() default CascadeType.NONE;

    Class<? extends EntityInterface> targetEntity();
}
