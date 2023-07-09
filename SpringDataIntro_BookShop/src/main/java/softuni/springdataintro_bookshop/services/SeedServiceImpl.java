package softuni.springdataintro_bookshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.springdataintro_bookshop.entities.*;
import softuni.springdataintro_bookshop.repositories.AuthorRepository;
import softuni.springdataintro_bookshop.repositories.BookRepository;
import softuni.springdataintro_bookshop.repositories.CategoryRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SeedServiceImpl implements SeedService {

    private static final String RESOURSE_PATH = "src/main/resources/files";
    private static final String AUTHORS_FILE_PATH = RESOURSE_PATH + "/authors.txt";
    private static final String CATEGORIES_FILE_PATH = RESOURSE_PATH + "/categories.txt";
    private static final String BOOKS_FILE_PATH = RESOURSE_PATH + "/books.txt";

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> s.split(" "))
                .map(name -> new Author(name[0], name[1]))
                .forEach(authorRepository::save);
    }


    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }


    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .stream()
                .filter(s -> !s.isBlank())
                .map(this::getBookFromFile)
                .forEach(bookRepository::save);
    }

    private Book getBookFromFile(String line) {
        String[] bookParts = line.split(" ");
        int editionTypeIndex = Integer.parseInt(bookParts[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];
        LocalDate publishDate = LocalDate.parse(bookParts[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(bookParts[2]);
        BigDecimal price = new BigDecimal(bookParts[3]);
        int ageRestrictionIndex = Integer.parseInt(bookParts[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionIndex];
        String bookTitle = Arrays.stream(bookParts)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(bookTitle, editionType, price, copies, publishDate, ageRestriction, author, categories);
    }
}
