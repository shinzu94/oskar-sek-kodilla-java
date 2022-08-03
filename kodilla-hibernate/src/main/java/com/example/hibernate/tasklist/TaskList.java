package com.example.hibernate.tasklist;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "TASKLISTS")
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "LISTNAME")
    private String listName;
    @Column(name = "DESCRIPTION")
    private String description;

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }
}