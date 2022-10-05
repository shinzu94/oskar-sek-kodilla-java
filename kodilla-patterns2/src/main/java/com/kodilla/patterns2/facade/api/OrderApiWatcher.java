package com.kodilla.patterns2.facade.api;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class OrderApiWatcher {
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) {
        log.info("Class: " + object.getClass().getName() + ", Args: " + order.toString() + ", " + userId);
    }
}