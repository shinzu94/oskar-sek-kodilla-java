package com.kodilla.patterns.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public final class Board extends Prototype<Board> {
    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TasksList list : lists) {
            s += list.toString() + "\n";
        }
        return s;
    }
}