package com.kodilla.kodillaspring.portfolio;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    @Test
    void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList toDoTaskList = (TaskList) context.getBean("toDo");
        TaskList inProgressTaskList = (TaskList) context.getBean("inProgress");
        TaskList doneTaskList = (TaskList) context.getBean("done");
        final String taskToDo = "task1";
        final String taskInProgress = "task2";
        final String taskDone = "task3";
        List<String> expectedToDo = List.of(taskToDo);
        List<String> expectedInProgress = List.of(taskInProgress);
        List<String> expectedDone = List.of(taskDone);


        board.addToDo(taskToDo);
        board.addInProgress(taskInProgress);
        board.addDone(taskDone);
        List<String> toDoList = board.getToDoList().getTasks();
        List<String> inProgressList = board.getInProgressList().getTasks();
        List<String> doneList = board.getDoneList().getTasks();
        List<String> toDoListFromBean = toDoTaskList.getTasks();
        List<String> inProgressListFromBean = inProgressTaskList.getTasks();
        List<String> doneListFromBean = doneTaskList.getTasks();


        assertEquals(expectedToDo, toDoList);
        assertEquals(expectedToDo, toDoListFromBean);
        assertEquals(expectedInProgress, inProgressList);
        assertEquals(expectedInProgress, inProgressListFromBean);
        assertEquals(expectedDone, doneList);
        assertEquals(expectedDone, doneListFromBean);
    }
}
