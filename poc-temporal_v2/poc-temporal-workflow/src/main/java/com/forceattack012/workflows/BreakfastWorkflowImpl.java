package com.forceattack012.workflows;

import com.forceattack012.activities.BreakfastActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BreakfastWorkflowImpl implements BreakfastWorkflow {
    private static final Logger logger = LoggerFactory.getLogger(BreakfastWorkflowImpl.class);

    // Define the Activity Execution options
    // StartToCloseTimeout or ScheduleToCloseTimeout must be set
    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build();

    // Create an client stub to activities that implement the given interface
    private final BreakfastActivities activities =
            Workflow.newActivityStub(BreakfastActivities.class, options);

    @Override
    public String makeBreakfast(String customerName) {
        logger.info("====== Start work flow =========");

        String coffee = activities.makeCoffee(customerName);
        String omlet = activities.makeOmlet(customerName);
        String serve = activities.serve(customerName);

        return String.format("%s\n%s\n%s", coffee, omlet, serve);
    }
}
