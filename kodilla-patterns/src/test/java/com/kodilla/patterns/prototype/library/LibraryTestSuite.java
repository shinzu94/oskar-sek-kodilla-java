package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //GIVEN
        Library library = new Library("Library");
        Set<Book> books = library.getBooks();
        Book firstBook = new Book("Title1", "Author1", LocalDate.of(2000, 11, 10));
        Book secondBook = new Book("Title2", "Author2", LocalDate.of(2003, 6, 24));
        Book thirdBook = new Book("Title3", "Author3", LocalDate.of(2001, 1, 14));
        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);

        //WHEN
        Library clonedLibrary = library.shallowCopy();
        clonedLibrary.setName("Library 2");
        Library deepClonedBoard = library.deepCopy();
        deepClonedBoard.setName("Library 3");

        library.getBooks().remove(thirdBook);

        //THEN
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedBoard.getBooks().size());
    }
}
