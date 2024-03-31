package com.forceattack012.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String sayHello(String name){
        return String.format("%s: %s", "Hello", name);
    }
}
