package com.forceattack012.config;

import com.forceattack012.constant.PocTemporalConstant;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {
    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        return WorkflowServiceStubs
                .newInstance(WorkflowServiceStubsOptions
                        .newBuilder()
                        .setTarget(PocTemporalConstant.HOST_TEMPORAL)
                        .build());
    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs workflowServiceStubs) {
        return WorkflowClient.newInstance(workflowServiceStubs,
                WorkflowClientOptions.newBuilder()
                        .setNamespace(PocTemporalConstant.NAME_SPACE)
                        .build());
    }
}
