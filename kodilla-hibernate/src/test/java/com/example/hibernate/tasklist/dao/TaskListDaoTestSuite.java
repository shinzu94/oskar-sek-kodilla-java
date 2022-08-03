package com.example.hibernate.tasklist.dao;

import com.example.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaskListDaoTestSuite {
    private static final String NAME = "Tasklist";
    private static final String DESCRIPTION = "Test: Learn Hibernate";
    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);
        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        List<TaskList> taskLists = taskListDao.findByListName(NAME);

        //Then
        assertEquals(1, taskLists.size());

        //CleanUp
        taskListDao.deleteById(id);
    }
}