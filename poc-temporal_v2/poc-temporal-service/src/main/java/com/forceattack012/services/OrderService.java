package com.forceattack012.services;

import com.forceattack012.entity.Order;
import com.forceattack012.models.OrderDTO;
import com.forceattack012.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(OrderDTO orderDTO){
        Order order = new Order(orderDTO.customerName(), orderDTO.orderName(), orderDTO.price(), orderDTO.time());
        return this.orderRepository.save(order);
    }
}
