package com.kodilla.patterns2.observer.homework;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    @Override
    public void update(StudentTasks studentTasks) {
        System.out.println(name + ": New task send by " + studentTasks.getUsername() + "\n" +
                " (total: " + studentTasks.getMessages().size() + " tasks)");
        updateCount++;
    }
}
