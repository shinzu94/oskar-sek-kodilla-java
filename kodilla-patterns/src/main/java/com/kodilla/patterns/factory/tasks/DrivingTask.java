package com.kodilla.patterns.factory.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingTask implements Task {
    @Getter
    private final String taskName;
    private final String where;
    private final String using;
    @Getter
    private boolean taskExecuted;

    @Override
    public void executeTask() {
        taskExecuted = true;
    }
}
