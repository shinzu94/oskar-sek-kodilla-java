package com.kodilla.patterns.factory.tasks;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskFactoryTestSuite {
    private static TaskFactory taskFactory;

    @BeforeAll
    private static void beforeAll() {
        taskFactory = new TaskFactory();
    }

    @Test
    void testFactoryDrivingTask() {
        //GIVEN
        //WHEN
        DrivingTask task = (DrivingTask) taskFactory.makeTask(TaskFactory.TaskType.DRIVING);

        //THEN
        assertEquals("Driving", task.getTaskName());
        assertEquals("Somewhere", task.getWhere());
        assertEquals("Something", task.getUsing());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //GIVEN
        //WHEN
        PaintingTask task = (PaintingTask) taskFactory.makeTask(TaskFactory.TaskType.PAINTING);

        //THEN
        assertEquals("Painting", task.getTaskName());
        assertEquals("Some", task.getColor());
        assertEquals("Something", task.getWhatToPaint());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    void testFactoryShoppingTask() {
        //GIVEN
        //WHEN
        ShoppingTask task = (ShoppingTask) taskFactory.makeTask(TaskFactory.TaskType.SHOPPING);

        //THEN
        assertEquals("Shopping", task.getTaskName());
        assertEquals("Something", task.getWhatToBuy());
        assertEquals(1, task.getQuantity());
        assertFalse(task.isTaskExecuted());
    }
}
