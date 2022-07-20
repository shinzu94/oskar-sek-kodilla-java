package com.kodilla.patterns.factory.tasks;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryDrivingTask() {
        //GIVEN
        TaskFactory factory = new TaskFactory();

        //WHEN
        Task task = factory.makeTask(TaskFactory.TaskType.DRIVING);

        //THEN
        assertEquals("Driving", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //GIVEN
        TaskFactory factory = new TaskFactory();

        //WHEN
        Task task = factory.makeTask(TaskFactory.TaskType.PAINTING);

        //THEN
        assertEquals("Painting", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }


    @Test
    void testFactoryShoppingTask() {
        //GIVEN
        TaskFactory factory = new TaskFactory();

        //WHEN
        Task task = factory.makeTask(TaskFactory.TaskType.SHOPPING);

        //THEN
        assertEquals("Shopping", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }
}
