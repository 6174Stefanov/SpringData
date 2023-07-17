package com.example.jsonex.productshop.repositories;

import com.example.jsonex.productshop.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
