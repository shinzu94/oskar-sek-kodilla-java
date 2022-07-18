package com.kodilla.kodillaspring.portfolio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public void addToDo(String task) {
        toDoList.add(task);
    }

    public void addInProgress(String task) {
        inProgressList.add(task);
    }

    public void addDone(String task) {
        doneList.add(task);
    }
}
