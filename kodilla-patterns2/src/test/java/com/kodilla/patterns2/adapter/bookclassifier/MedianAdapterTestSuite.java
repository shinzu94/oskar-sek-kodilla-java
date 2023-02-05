package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    void publicationYearMedianTest() {
        //GIVEN
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("Testowy1", "Testowy1", 1990, "Testowy1"));
        books.add(new Book("Testowy2", "Testowy2", 1995, "Testowy2"));
        books.add(new Book("Testowy3", "Testowy3", 1997, "Testowy3"));
        books.add(new Book("Testowy4", "Testowy4", 2000, "Testowy4"));
        books.add(new Book("Testowy5", "Testowy5", 2001, "Testowy5"));
        books.add(new Book("Testowy6", "Testowy6", 2002, "Testowy6"));
        books.add(new Book("Testowy7", "Testowy7", 2006, "Testowy7"));

        //WHEN
        int median = medianAdapter.publicationYearMedian(books);

        //THEN
        assertEquals(2000, median);
    }
}
