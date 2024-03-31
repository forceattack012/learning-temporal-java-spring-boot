package com.forceattack012.controller;

import com.forceattack012.constant.PocTemporalConstant;
import com.forceattack012.workflows.BreakfastWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/breakfast")
public class BreakfastController {
    private static final Logger logger = LoggerFactory.getLogger(BreakfastController.class);
    private final WorkflowClient workflowClient;
    public BreakfastController(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    @GetMapping("/{name}")
    public String wantBreakfast(@PathVariable String name){
        logger.info("start request name : {}", name);
        try {
            WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
                    .setWorkflowId(UUID.randomUUID().toString())
                    .setTaskQueue(PocTemporalConstant.QUEUE)
                    .build();

            BreakfastWorkflow breakfastWorkflow = workflowClient.newWorkflowStub(BreakfastWorkflow.class, workflowOptions);
            WorkflowClient.start(() -> breakfastWorkflow.makeBreakfast(name));
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
        }

        return "eat";
    }
}
