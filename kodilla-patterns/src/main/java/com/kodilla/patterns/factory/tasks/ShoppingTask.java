package com.kodilla.patterns.factory.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean taskExecuted;

    @Override
    public void executeTask() {
        taskExecuted = true;
    }
}
