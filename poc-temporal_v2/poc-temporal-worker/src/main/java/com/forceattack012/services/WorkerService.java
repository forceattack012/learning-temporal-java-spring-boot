package com.forceattack012.services;

import com.forceattack012.activities.BreakfastActivitiesImpl;
import com.forceattack012.constant.PocTemporalConstant;
import com.forceattack012.services.OrderService;
import com.forceattack012.workflows.BreakfastWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final OrderService orderService;

    @Autowired
    public WorkerService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void run(){
        // Specify the IP address and port for the Service Stubs options
        WorkflowServiceStubsOptions stubsOptions = WorkflowServiceStubsOptions.newBuilder()
                .setTarget(PocTemporalConstant.HOST_TEMPORAL)
                .build();

        // Generate the gRPC stubs using the options provided
        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(stubsOptions);

        // Specify the namespace in the Client options
        WorkflowClientOptions options = WorkflowClientOptions.newBuilder()
                .setNamespace(PocTemporalConstant.NAME_SPACE)
                .build();

        // Initialize the Temporal Client, passing in the gRPC stubs and Client optins
        WorkflowClient client = WorkflowClient.newInstance(service, options);

        // Initialize a WorkerFactory, passing in the Temporal Client (WorkflowClient)
        WorkerFactory factory = WorkerFactory.newInstance(client);

        // Create a new Worker
        Worker worker = factory.newWorker(PocTemporalConstant.QUEUE);

        // Register the Workflow by passing in the class to the worker
        worker.registerWorkflowImplementationTypes(BreakfastWorkflowImpl.class);

        // Register the Activities by passing in an Activities object used for execution
        worker.registerActivitiesImplementations(new BreakfastActivitiesImpl(orderService));

        // Start the Worker
        factory.start();
    }
}
