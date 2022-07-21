package com.kodilla.patterns.factory.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean taskExecuted;

    @Override
    public void executeTask() {
        taskExecuted = true;
    }
}
