package softuni.springdataintro_bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.springdataintro_bookshop.entities.Author;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findDistinctByBooksReleaseDateBefore(LocalDate releaseDate);
}
