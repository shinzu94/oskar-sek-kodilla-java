package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //GIVEN
        Library library = new Library("Library");
        Set<Book> books = library.getBooks();
        Book firstBook = new Book("Title1", "Author1", LocalDate.of(2000, 11, 10));
        Book secondBook = new Book("Title2", "Author2", LocalDate.of(2003, 6, 24));
        Book thirdBook = new Book("Title3", "Author3", LocalDate.of(2001, 1, 14));
        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);
        Exception exception = null;

        //WHEN
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            exception = e;
        }

        //making a deep copy of object board
        Library deepClonedBoard = null;
        try {
            deepClonedBoard = library.deepCopy();
            deepClonedBoard.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            exception = e;
        }

        library.getBooks().remove(thirdBook);

        //THEN
        assertNull(exception);
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedBoard.getBooks().size());
    }
}
