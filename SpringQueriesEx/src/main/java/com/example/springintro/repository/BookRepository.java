package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);


    List<Book> findByAgeRestriction(AgeRestriction restriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType type, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);
    
    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findByTitleContaining(String contains);

    List<Book> findByAuthorLastNameStartingWith(String startingWith);

    @Query("select count (b) from Book b where length(b.title) > :length")
    int countBooksWithTitleLongerThan(int length);
}
