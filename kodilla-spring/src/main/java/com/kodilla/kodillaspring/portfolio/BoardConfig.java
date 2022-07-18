package com.kodilla.kodillaspring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean(name = "toDo")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgress")
    public TaskList getInProgress() {
        return new TaskList();
    }

    @Bean(name = "done")
    public TaskList getDone() {
        return new TaskList();
    }

    @Bean(name = "board")
    public Board getBoard() {
        return new Board(getToDoList(), getInProgress(), getDone());
    }
}
