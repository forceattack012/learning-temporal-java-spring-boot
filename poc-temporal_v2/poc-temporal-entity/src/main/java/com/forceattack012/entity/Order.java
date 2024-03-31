package com.forceattack012.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "price")
    private double price;
    @Column(name = "time_used")
    private double time;

    public Order(){

    }
    public Order(String customerName, String orderName, double price, double time) {
        this.customerName = customerName;
        this.orderName = orderName;
        this.price = price;
        this.time = time;
    }
}
