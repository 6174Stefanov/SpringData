package softuni.springdataintro_bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.springdataintro_bookshop.entities.Author;
import softuni.springdataintro_bookshop.entities.Book;
import softuni.springdataintro_bookshop.repositories.AuthorRepository;
import softuni.springdataintro_bookshop.repositories.BookRepository;
import softuni.springdataintro_bookshop.services.SeedService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    // this.seedService.seedAll();
    // this.printBookTitlesAfter2000();
    // this.printAuthorsWithBooksBefore1990();
        this.printAuthorsOrderedByBookCount();
    }

    private void printAuthorsOrderedByBookCount() {
        List<Author> authors = this.authorRepository.findAll();
        authors.stream().sorted(Comparator.comparingInt(a -> a.getBooks().size()))
                .limit(10)
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEachOrdered(a -> System.out.printf("%s %s -> %d%n", a.getFirst_name(), a.getLast_name(), a.getBooks().size()));


    }

    private void printAuthorsWithBooksBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirst_name() + " " + a.getLast_name()));
    }

    private void printBookTitlesAfter2000(){
        LocalDate year2000 = LocalDate.of(2000, 12, 31);
        List<Book> booksAfter2000 = this.bookRepository.findByReleaseDateAfter(year2000);

        booksAfter2000.forEach(book -> System.out.println(book.getTitle()));
    }
}
