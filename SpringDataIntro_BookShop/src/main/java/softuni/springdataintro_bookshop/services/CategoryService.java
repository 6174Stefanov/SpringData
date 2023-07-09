package softuni.springdataintro_bookshop.services;

import softuni.springdataintro_bookshop.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
