package com.kodilla.patterns.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class TasksList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public TasksList(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "   List [" + name + "]";
        for (Task task : tasks) {
            s += "\n" + task.toString();
        }
        return s;
    }
}