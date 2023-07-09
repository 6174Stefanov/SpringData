package softuni.springdataintro_bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.springdataintro_bookshop.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByReleaseDateAfter(LocalDate releaseDate);
}
