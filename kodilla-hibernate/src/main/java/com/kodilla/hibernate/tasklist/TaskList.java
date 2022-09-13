package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private String listName;
    private String description;
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }
}