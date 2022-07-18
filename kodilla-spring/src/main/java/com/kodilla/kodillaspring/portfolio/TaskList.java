package com.kodilla.kodillaspring.portfolio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskList {
    private final List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    void add(String task) {
        tasks.add(task);
    }
}
