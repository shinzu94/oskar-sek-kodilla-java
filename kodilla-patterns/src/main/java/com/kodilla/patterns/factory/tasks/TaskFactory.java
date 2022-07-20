package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public final Task makeTask(final TaskType taskType) {
        if (taskType.equals(TaskType.DRIVING)) {
            return new DrivingTask("Driving", "Somewhere", "Something");
        } else if (taskType.equals(TaskType.PAINTING)) {
            return new PaintingTask("Painting", "Some", "Something");
        } else if (taskType.equals(TaskType.SHOPPING)) {
            return new ShoppingTask("Shopping", "Something", 1);
        }
        return null;
    }

    public enum TaskType {
        DRIVING,
        PAINTING,
        SHOPPING
    }
}
