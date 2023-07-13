package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findAllTitlesByEditionAndCopies(EditionType type, int copies);

    List<Book> findAllWithPriceNotBetween(float lowerBound, float upperBound);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(int releaseYear);

    List<Book> findBooksReleasedBeforeDate(String date);

    List<String> findAllTitlesContaining(String contains);

    List<Book> findByAuthorLastNameStartsWith(String startingWith);

    int countBooksWithTitleLongerThan(int length);
}
