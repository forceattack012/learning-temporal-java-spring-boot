package com.forceattack012.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface BreakfastWorkflow {
    @WorkflowMethod
    String makeBreakfast(String customerName);
}