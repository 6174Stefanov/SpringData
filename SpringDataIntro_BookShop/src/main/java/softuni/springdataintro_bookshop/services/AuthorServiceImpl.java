package softuni.springdataintro_bookshop.services;

import org.springframework.stereotype.Service;
import softuni.springdataintro_bookshop.entities.Author;
import softuni.springdataintro_bookshop.repositories.AuthorRepository;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();
        int randomAuthorId = new Random().nextInt((int) size) + 1;
        return this.authorRepository.findById(randomAuthorId).get();
    }
}
