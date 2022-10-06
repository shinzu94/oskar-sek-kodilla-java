package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        // Given
        StudentTasks oskar = new StudentTasks("Oskar");
        StudentTasks kamil = new StudentTasks("Kamil");
        StudentTasks sebastian = new StudentTasks("Sebastian");
        Mentor wlodek = new Mentor("Włodek");
        Mentor karol = new Mentor("Karol");
        oskar.registerObserver(wlodek);
        sebastian.registerObserver(karol);
        kamil.removeObserver(karol);
        // When
        oskar.addTask("7.1. Wstęp do programowania funkcyjnego, czyli wyrażenia lambda");
        kamil.addTask("24.2. Wzorzec Dekorator");
        oskar.addTask("7.3. Poznanie funkcji stream(), filter(), map() i collect()");
        sebastian.addTask("15. Wzorce projektowe cz. 1");
        oskar.addTask("7.4. Poznanie flatMap() i reduce()");
        sebastian.addTask("15.2. Prototype");
        kamil.addTask("24.4. Wzorzec Obserwator");
        // Then
        assertEquals(3, wlodek.getUpdateCount());
        assertEquals(2, karol.getUpdateCount());
    }
}