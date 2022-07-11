package com.kodilla.good.patterns.challenges.infrastructure.dataSource;

import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;

import java.util.Map;

public interface DataSourceInterface {
    Map<String, EntityInterface> getData(Class<? extends EntityInterface> entity);
}
