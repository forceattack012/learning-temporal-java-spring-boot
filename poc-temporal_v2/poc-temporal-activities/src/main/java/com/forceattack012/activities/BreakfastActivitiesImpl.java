package com.forceattack012.activities;

import com.forceattack012.models.OrderDTO;
import com.forceattack012.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreakfastActivitiesImpl implements BreakfastActivities {
    private static final Logger logger = LoggerFactory.getLogger(BreakfastActivitiesImpl.class);
    private final OrderService orderService;

    public BreakfastActivitiesImpl(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public String makeCoffee(String name) {
        logger.info("name : {}, make a coffee", name);

        this.orderService.createOrder(new OrderDTO(name, "coffee", 25.6, 15));

        return "make a coffee";
    }

    @Override
    public String makeOmlet(String name) {
        logger.info("name : {}, make an omlet", name);

        this.orderService.createOrder(new OrderDTO(name, "omlet", 100, 10));

        return "make an omlet";
    }

    @Override
    public String serve(String name) {
        logger.info("serve to name : {}", name);
        return "serve to name : " + name;
    }
}
