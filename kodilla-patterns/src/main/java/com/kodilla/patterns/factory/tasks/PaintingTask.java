package com.kodilla.patterns.factory.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaintingTask implements Task {
    @Getter
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    @Getter
    private boolean taskExecuted;

    @Override
    public void executeTask() {
        taskExecuted = true;
    }
}
