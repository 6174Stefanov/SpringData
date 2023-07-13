package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //  seedData();

        Scanner scanner = new Scanner(System.in);

//        01 Finding Books list by age restriction(minor, teen etc.)
//         String restriction = scanner.nextLine();
//         this.bookService.findAllTitlesByAgeRestriction(restriction)
//                .forEach(System.out::println);
//
//        02 Finding books by edition with less than selected copies
//          this.bookService.findAllTitlesByEditionAndCopies(EditionType.GOLD, 5000)
//                 .forEach(System.out::println);
//
//         03 Books with price lower or higher than selected
//          this.bookService.findAllWithPriceNotBetween(5, 40)
//                 .forEach(book -> System.out.println(book.getTitle() + "-" + book.getPrice()));
//
//         04 Finding books that are not released in selected year
//
//         int releaseYear = Integer.parseInt(scanner.nextLine());
//         this.bookService.findByReleaseDateBeforeOrReleaseDateAfter(releaseYear)
//                .forEach(book -> System.out.println(book.getTitle()));

//
        //05 Books released before date(date formatter)
//       String date = scanner.nextLine();
//       this.bookService.findBooksReleasedBeforeDate(date)
//               .forEach(book -> System.out.printf("%s %s %.2f%n",
//                       book.getTitle(), book.getEditionType(), book.getPrice()));

//        06 Find authors witch names end with given string
//        String endsWith = scanner.nextLine();
//        this.authorService.byFirstNameEndingWith(endsWith)
//                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

//        07 Titles containing string
//        String contains = scanner.nextLine();
//        this.bookService.findAllTitlesContaining(contains)
//                .forEach(System.out::println);

//        08 Finding books whose author last name starts with given string
//        String startingWith = scanner.nextLine();
//        this.bookService.findByAuthorLastNameStartsWith(startingWith)
//                .forEach(book -> System.out.printf("%s (%s %s)%n",
//                        book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));

//        09 Books with length greater than input
//        int length = scanner.nextInt();
//        int totalBooks = this.bookService.countBooksWithTitleLongerThan(length);
//        System.out.printf("There are %d books with longer title than %d symbols", totalBooks, length);

//        printAllBooksAfterYear(2000);
//         printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//           printAllAuthorsAndNumberOfTheirBooks();
//          pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
