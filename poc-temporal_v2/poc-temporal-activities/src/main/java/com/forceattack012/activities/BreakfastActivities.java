package com.forceattack012.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface BreakfastActivities {
    String makeCoffee(String name);
    String makeOmlet(String name);
    String serve(String name);
}
