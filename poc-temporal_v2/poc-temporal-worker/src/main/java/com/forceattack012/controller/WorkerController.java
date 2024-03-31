package com.forceattack012.controller;

import com.forceattack012.entity.Order;
import com.forceattack012.models.OrderDTO;
import com.forceattack012.services.GreetingService;
import com.forceattack012.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {
    private final GreetingService greetingService;

    public WorkerController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/{name}")
    public String createOrder(@PathVariable String name){
        return greetingService.sayHello(name);
    }
}
