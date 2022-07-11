package com.kodilla.good.patterns.challenges.infrastructure;

import com.kodilla.good.patterns.challenges.infrastructure.dataSource.DataSource;
import com.kodilla.good.patterns.challenges.infrastructure.dataSource.DataSourceInterface;
import com.kodilla.good.patterns.challenges.infrastructure.entity.EntityInterface;
import com.kodilla.good.patterns.challenges.repository.*;
import com.kodilla.good.patterns.challenges.service.ConsoleInformationService;
import com.kodilla.good.patterns.challenges.service.InformationServiceInterface;
import com.kodilla.good.patterns.challenges.service.OrderPositionService;
import com.kodilla.good.patterns.challenges.service.OrderService;

abstract public class ComponentRegistry {
    private static OrderService orderService;
    private static OrderPositionService orderPositionService;
    private static OrderRepository orderRepository;
    private static OrderPositionRepository orderPositionRepository;
    private static ProductRepository productRepository;
    private static InformationServiceInterface informationServiceInterface;
    private static OrderRequestRetriever orderRequestRetriever;
    private static DataSourceInterface dataSourceInterface;

    public static EntityRepositoryInterface getRepository(Class<? extends EntityInterface> entityClass) {
        return EntityRepository.of(entityClass);
    }

    public static OrderRepository getOrderRepository() {
        if (null != orderRepository) {
            return orderRepository;
        }
        synchronized (ComponentRegistry.class) {
            if (null == orderRepository) {
                orderRepository = new OrderRepository();
            }
            return orderRepository;
        }
    }

    public static OrderPositionRepository getOrderPositionRepository() {
        if (null != orderPositionRepository) {
            return orderPositionRepository;
        }
        synchronized (ComponentRegistry.class) {
            if (null == orderPositionRepository) {
                orderPositionRepository = new OrderPositionRepository();
            }
            return orderPositionRepository;
        }
    }

    public static ProductRepository getProductRepository() {
        if (null != productRepository) {
            return productRepository;
        }
        synchronized (ComponentRegistry.class) {
            if (null == productRepository) {
                productRepository = new ProductRepository();
            }
            return productRepository;
        }
    }

    public static OrderPositionService getOrderPositionService() {
        if (null != orderPositionService) {
            return orderPositionService;
        }
        synchronized (ComponentRegistry.class) {
            if (null == orderPositionService) {
                orderPositionService = new OrderPositionService();
            }
            return orderPositionService;
        }
    }

    public static OrderService getOrderService() {
        if (null != orderService) {
            return orderService;
        }
        synchronized (ComponentRegistry.class) {
            if (null == orderService) {
                orderService = new OrderService();
            }
            return orderService;
        }
    }

    public static InformationServiceInterface getInformationServiceInterface() {
        if (null != informationServiceInterface) {
            return informationServiceInterface;
        }
        synchronized (ComponentRegistry.class) {
            if (null == informationServiceInterface) {
                informationServiceInterface = new ConsoleInformationService();
            }
            return informationServiceInterface;
        }
    }

    public static OrderRequestRetriever getOrderRequestRetriever() {
        if (null != orderRequestRetriever) {
            return orderRequestRetriever;
        }
        synchronized (ComponentRegistry.class) {
            if (null == orderRequestRetriever) {
                orderRequestRetriever = new OrderRequestRetriever();
            }
            return orderRequestRetriever;
        }
    }

    public static DataSourceInterface getDataSourceInterface() {
        if (null != dataSourceInterface) {
            return dataSourceInterface;
        }
        synchronized (ComponentRegistry.class) {
            if (null == dataSourceInterface) {
                dataSourceInterface = new DataSource();
            }
            return dataSourceInterface;
        }
    }
}
