package com.kodilla.patterns.prototype.library;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Book {
    private final String title;
    private final String author;
    private final LocalDate publicationDate;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
