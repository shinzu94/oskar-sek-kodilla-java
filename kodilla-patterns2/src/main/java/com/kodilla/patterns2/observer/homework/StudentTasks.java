package com.kodilla.patterns2.observer.homework;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentTasks implements Observable {
    @Getter(AccessLevel.NONE)
    private final List<Observer> observers = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();
    private final String username;

    public StudentTasks(String username) {
        this.username = username;
    }

    public void addTask(String post) {
        messages.add(post);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
