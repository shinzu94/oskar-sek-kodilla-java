package com.kodilla.patterns.factory.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShoppingTask implements Task {
    @Getter
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    @Getter
    private boolean taskExecuted;

    @Override
    public void executeTask() {
        taskExecuted = true;
    }
}
