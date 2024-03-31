package com.forceattack012;

import com.forceattack012.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SelfHostedWorkerApplication implements CommandLineRunner {
    @Autowired
    private WorkerService workerService;

    public static void main(String[] args) {
        SpringApplication.run(SelfHostedWorkerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        workerService.run();
    }
}
